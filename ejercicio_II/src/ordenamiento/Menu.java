package ordenamiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };

        int opcion;
        int N;
        
        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("**Selección sort (Selección)**");
                                  
                    sort(arr); 
                    System.out.println("Sorted array"); 
                    printSort(arr); 
                    
                    break;
                case 2:
                    System.out.println("**Bubble sort (Burbuja)**");
                                                            
                    int n = arr.length;
                    bubbleSort(arr, n);
                    System.out.println("Sorted array: ");
                    printBubble(arr, n);
                    
                    break;
                case 3:
                    System.out.println("**Insertion sort (Inserción)**");
                    
                    insertion(arr);
                    printInsertion(arr);
                    
                    break;
                case 4:
                    System.out.println("**Merge sort (Combinación)**");
                    
                    printMerge(arr);                    
                    merge(arr, 0, arr.length - 1);
                    System.out.println("\nSorted array is");
                    printMerge(arr);
                    
                    break;
                case 5:
                    System.out.println("**Quick sort (Rápida)**");
                    
                     N = arr.length;

                    // Function call
                    quickSort(arr, 0, N - 1);
                    System.out.println("Sorted array:");
                    printArrQuick(arr);
                    
                    break;
                case 6:
                    System.out.println("**Heap sort (Montón)**");
                    
                    N = arr.length;                    
                    heap(arr);
                    System.out.println("Sorted array is");
                    printHeap(arr);
                    
                    break;
                case 7:
                    System.out.println("**Counting sort (Conteo)**");
                    
                    int[] outputArray = counting(arr);
             
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(outputArray[i] + " ");
                    }
                    
                    break;
                case 8:
                    System.out.println("**Radix sort (Raíz)**");
                    	
                    N= arr.length;
                    
                    // Function Call
                    radix(arr, N);
                    printRadix(arr, N);
                    
                    break;
                case 9:
                    System.out.println("**Bucket sort (Cubo)**");
                    
                    float[] arrF = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
                    bucket(arrF);
                    System.out.println("Sorted array is:");
                    for (float num : arr) {
                        System.out.print(num + " ");
                    }
                    
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion  < 10);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n**Como desea ordenar**");
        System.out.println("-------------------------------------");
        System.out.println("1. Selection sort (Selección)");
        System.out.println("2. Bubble sort (Burbuja)");
        System.out.println("3. Insertion sort (Inserción)");
        System.out.println("4. Merge sort (Combinación)");
        System.out.println("5. Quick sort (Rápida)");
        System.out.println("6. Heap sort (Montón)");
        System.out.println("7. Counting sort (Conteo)");
        System.out.println("8. Radix sort (Raíz)");
        System.out.println("9. Bucket sort (Cubo)");
        System.out.println("10. Salir");
        System.out.println("-------------------------------------");
        System.out.print("Seleccione una opción: ");
    }
    
    public static void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        }
    }
    
    public static void printSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
    
    public static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                     
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
 
            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
    
    public static void printBubble(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static void insertion(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    public static void printInsertion(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
    
    
    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    public static void merge(int arr[], int l, int r)
    {
        if (l < r) {
 
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            merge(arr, l, m);
            merge(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
    public static  void printMerge(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static  void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static int partition(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    public static void printArrQuick(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void heap(int arr[])
    {
        int N = arr.length;
 
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    public static void heapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }
    
    public static void printHeap(int arr[])
    {
        int N = arr.length;
 
        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static int[] counting(int[] inputArray) {
        int N = inputArray.length;
        int M = 0;
 
        for (int i = 0; i < N; i++) {
            M = Math.max(M, inputArray[i]);
        }
 
        int[] countArray = new int[M + 1];
 
        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]]++;
        }
 
        for (int i = 1; i <= M; i++) {
            countArray[i] += countArray[i - 1];
        }
 
        int[] outputArray = new int[N];
 
        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }
 
        return outputArray;
    }
    
    public static void radix(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    
    public static void printRadix(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    
    public static void bucket(float[] arr) {
        int n = arr.length;

        // 1) Create n empty buckets
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int bi = (int) (n * arr[i]);
            buckets[bi].add(arr[i]);
        }

        // 3) Sort individual buckets using insertion sort
        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
    
    public static void insertionSort(List<Float> bucket) {
        for (int i = 1; i < bucket.size(); ++i) {
            float key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }
}
