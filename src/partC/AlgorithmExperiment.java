import java.util.Random;

public class AlgorithmExperiment {

    public static void main(String[] args) {
        int[] sizes = {20, 50, 100, 500};
        Random r = new Random(42);

        System.out.println("===== RANDOM INPUT EXPERIMENT =====");
        System.out.printf("%-15s %-10s %-15s %-15s%n",
                "Algorithm", "Size", "Comparisons", "Time (ns)");

        for (int size : sizes) {
            int[] original = new int[size];
            for (int i = 0; i < size; i++) original[i] = r.nextInt(1000);

            runOne("Selection", original.clone(), "selection");
            runOne("Insertion", original.clone(), "insertion");
            runOne("Merge",     original.clone(), "merge");
            runOne("Quick",     original.clone(), "quick");
        }

        System.out.println("\n===== ALMOST-SORTED INPUT (n=100) =====");
        int n = 100;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) sorted[i] = i + 1;
        int[][] swaps = {{0,1},{20,21},{40,41},{60,61},{80,81}};
        for (int[] s : swaps) {
            int t = sorted[s[0]]; sorted[s[0]] = sorted[s[1]]; sorted[s[1]] = t;
        }

        runOne("Selection", sorted.clone(), "selection");
        runOne("Insertion", sorted.clone(), "insertion");
        runOne("Merge",     sorted.clone(), "merge");
        runOne("Quick",     sorted.clone(), "quick");
    }

    private static void runOne(String name, int[] arr, String type) {
        long start = System.nanoTime();
        long comps = 0;

        switch (type) {
            case "selection":
                SortingAlgorithms.selectionSort(arr);
                comps = SortingAlgorithms.selectionComparisons;
                break;
            case "insertion":
                SortingAlgorithms.insertionSort(arr);
                comps = SortingAlgorithms.insertionComparisons;
                break;
            case "merge":
                SortingAlgorithms.mergeSort(arr);
                comps = SortingAlgorithms.mergeComparisons;
                break;
            case "quick":
                SortingAlgorithms.quickSort(arr);
                comps = SortingAlgorithms.quickComparisons;
                break;
        }

        long elapsed = System.nanoTime() - start;
        System.out.printf("%-15s %-10d %-15d %-15d%n", name, arr.length, comps, elapsed);
    }
}
