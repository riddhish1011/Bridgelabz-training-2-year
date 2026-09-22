public class DSAComplexityAssignment {

    // =========================================================
    // TC-1: LINEAR SEARCH
    // =========================================================

    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    /*
     * TC-1: LINEAR SEARCH
     *
     * Best Case:
     * Target is at the first position.
     * Only one comparison is required.
     * Time Complexity = O(1)
     *
     * Average Case:
     * Target is at a random position.
     * Approximately N/2 elements are checked.
     * Time Complexity = O(N)
     *
     * Worst Case:
     * Target is at the last position or is not present.
     * N elements may be checked.
     * Time Complexity = O(N)
     *
     * Space Complexity:
     * Only a constant number of variables are used.
     * Auxiliary Space = O(1)
     */


    // =========================================================
    // TC-2: ITERATIVE BINARY SEARCH
    // =========================================================

    public static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /*
     * TC-2: ITERATIVE BINARY SEARCH
     *
     * Binary Search divides the search space by 2
     * after every comparison.
     *
     * N -> N/2 -> N/4 -> N/8 -> ...
     *
     * After k comparisons:
     *
     * N / 2^k = 1
     *
     * Therefore:
     *
     * k = log2(N)
     *
     * Worst Case Time Complexity = O(log N)
     *
     * Space Complexity:
     * This is iterative Binary Search.
     * Only low, high and mid variables are used.
     *
     * Auxiliary Space = O(1)
     */


    // =========================================================
    // TC-3: MERGE SORT
    // =========================================================

    public static void mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }


    public static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /*
     * TC-3: MERGE SORT TIME COMPLEXITY
     *
     * Recurrence:
     *
     * T(N) = 2T(N/2) + O(N)
     *
     * Each level of the recursion tree performs O(N) work.
     * Number of levels = log2(N)
     *
     * Therefore:
     *
     * Time Complexity = O(N log N)
     *
     * Best Case    = O(N log N)
     * Average Case = O(N log N)
     * Worst Case   = O(N log N)
     *
     *
     * SC-3: MERGE SORT SPACE COMPLEXITY
     *
     * Merge Sort creates temporary arrays while merging.
     *
     * Temporary arrays = O(N)
     * Recursion stack  = O(log N)
     *
     * Overall auxiliary space:
     *
     * O(N) + O(log N) = O(N)
     *
     * Auxiliary Space = O(N)
     */


    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String[] args) {

        // Sample array from the assignment
        int[] arr = {8, 61, 2, 3, 4, 0};

        // Linear Search
        int linearResult = linearSearch(arr, 8);
        System.out.println("Linear Search index: " + linearResult);

        // Sorted array from the assignment
        int[] sortedArr = {0, 2, 3, 4, 8, 61};

        // Binary Search
        int binaryResult = binarySearch(sortedArr, 4);
        System.out.println("Binary Search index: " + binaryResult);

        // Merge Sort
        mergeSort(arr, 0, arr.length - 1);

        System.out.print("Merge Sorted Array: ");

        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println();
    }
}
