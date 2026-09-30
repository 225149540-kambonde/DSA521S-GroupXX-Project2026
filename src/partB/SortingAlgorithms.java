public class SortingAlgorithms {

    public static long selectionComparisons = 0;
    public static long selectionSwaps = 0;

    public static long insertionComparisons = 0;
    public static long insertionShifts = 0;

    public static long mergeComparisons = 0;

    public static long quickComparisons = 0;

    public static void selectionSort(int[] a) {
        selectionComparisons = 0;
        selectionSwaps = 0;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                selectionComparisons++;
                if (a[j] < a[minIndex]) minIndex = j;
            }
            if (minIndex != i) {
                int tmp = a[i]; a[i] = a[minIndex]; a[minIndex] = tmp;
                selectionSwaps++;
            }
        }
    }

    public static void insertionSort(int[] a) {
        insertionComparisons = 0;
        insertionShifts = 0;
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0) {
                insertionComparisons++;
                if (a[j] > key) {
                    a[j + 1] = a[j];
                    insertionShifts++;
                    j--;
                } else break;
            }
            a[j + 1] = key;
        }
    }

    public static void mergeSort(int[] a) {
        mergeComparisons = 0;
        mergeSortRec(a, 0, a.length - 1);
    }

    private static void mergeSortRec(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortRec(a, low, mid);
            mergeSortRec(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = a[low + i];
        for (int j = 0; j < n2; j++) R[j] = a[mid + 1 + j];

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            mergeComparisons++;
            if (L[i] <= R[j]) a[k++] = L[i++];
            else              a[k++] = R[j++];
        }
        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];
    }

    public static void quickSort(int[] a) {
        quickComparisons = 0;
        quickSortRec(a, 0, a.length - 1);
    }

    private static void quickSortRec(int[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quickSortRec(a, low, p - 1);
            quickSortRec(a, p + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            quickComparisons++;
            if (a[j] <= pivot) {
                i++;
                int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
            }
        }
        int tmp = a[i + 1]; a[i + 1] = a[high]; a[high] = tmp;
        return i + 1;
    }
}
