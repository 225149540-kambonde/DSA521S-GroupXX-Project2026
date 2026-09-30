import java.util.Scanner;

class Student {
    long studentNo;
    String name, serviceType;
    int serviceTime;

    Student(long studentNo, String name, String serviceType, int serviceTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return studentNo + " | " + name + " | " + serviceType + " | " + serviceTime + " min";
    }
}

class Node {
    Student data;
    Node next;
    Node(Student d) { data = d; }
}

public class CampusServiceCentre {

    static Node qFront = null, qRear = null;
    static Node llHead = null;
    static int[] times = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n=== CAMPUS SERVICE CENTRE ===");
            System.out.println("1. Enqueue Student");
            System.out.println("2. Dequeue Student");
            System.out.println("3. Display Queue");
            System.out.println("4. Insert Record (LL)");
            System.out.println("5. Display Records");
            System.out.println("6. Search Record");
            System.out.println("7. Delete Record");
            System.out.println("8. Daily Statistics");
            System.out.println("9. Sort Service Times");
            System.out.println("10. Sorting Experiment");
            System.out.println("11. Exit");
            System.out.print("Select option: ");

            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: enqueue(sc); break;
                case 2: dequeue(); break;
                case 3: displayQueue(); break;
                case 4: insertRecord(sc); break;
                case 5: displayRecords(); break;
                case 6: searchRecord(sc); break;
                case 7: deleteRecord(sc); break;
                case 8: dailyStats(); break;
                case 9: sortServiceTimes(); break;
                case 10: sortingExperiment(); break;
                case 11: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid option.");
            }
        } while (ch != 11);

        sc.close();
    }

    static void enqueue(Scanner sc) {
        System.out.print("No, Name, Type, Time: ");
        long no = sc.nextLong();
        String name = sc.next();
        String type = sc.next();
        int time = sc.nextInt();
        sc.nextLine();

        Student s = new Student(no, name, type, time);
        Node n = new Node(s);

        if (qRear == null) qFront = qRear = n;
        else { qRear.next = n; qRear = n; }
        System.out.println(name + " added to queue.");
    }

    static void dequeue() {
        if (qFront == null) { System.out.println("Queue empty."); return; }
        System.out.println("Served: " + qFront.data);
        qFront = qFront.next;
        if (qFront == null) qRear = null;
    }

    static void displayQueue() {
        if (qFront == null) { System.out.println("Queue empty."); return; }
        for (Node c = qFront; c != null; c = c.next) System.out.println(c.data);
    }

    static void insertRecord(Scanner sc) {
        System.out.print("No, Name, Type, Time: ");
        long no = sc.nextLong();
        String name = sc.next();
        String type = sc.next();
        int time = sc.nextInt();
        sc.nextLine();

        Node n = new Node(new Student(no, name, type, time));
        n.next = llHead;
        llHead = n;
        System.out.println(name + " inserted at beginning.");
    }

    static void displayRecords() {
        if (llHead == null) { System.out.println("List empty."); return; }
        for (Node c = llHead; c != null; c = c.next) System.out.println(c.data);
    }

    static void searchRecord(Scanner sc) {
        System.out.print("Enter student number to search: ");
        long target = sc.nextLong();
        sc.nextLine();
        for (Node c = llHead; c != null; c = c.next) {
            if (c.data.studentNo == target) {
                System.out.println("Found: " + c.data);
                return;
            }
        }
        System.out.println("Not found.");
    }

    static void deleteRecord(Scanner sc) {
        System.out.print("Enter student number to delete: ");
        long target = sc.nextLong();
        sc.nextLine();

        if (llHead == null) { System.out.println("List empty."); return; }
        if (llHead.data.studentNo == target) {
            System.out.println(llHead.data.name + " deleted.");
            llHead = llHead.next;
            return;
        }
        for (Node c = llHead; c != null && c.next != null; c = c.next) {
            if (c.next.data.studentNo == target) {
                System.out.println(c.next.data.name + " deleted.");
                c.next = c.next.next;
                return;
            }
        }
        System.out.println("Not found.");
    }

    static void dailyStats() {
        int tot = 0, max = times[0], min = times[0], over10 = 0;
        for (int t : times) {
            tot += t;
            if (t > max) max = t;
            if (t < min) min = t;
            if (t > 10) over10++;
        }
        System.out.println("Total: " + times.length + " | Sum: " + tot
                + " | Avg: " + ((double) tot / times.length)
                + " | Max: " + max + " | Min: " + min + " | >10m: " + over10);
    }

    static void sortServiceTimes() {
        int[] arr = times.clone();
        SortingAlgorithms.mergeSort(arr);
        System.out.print("Sorted: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    static void sortingExperiment() {
        int[] sizes = {20, 50, 100, 500};
        java.util.Random r = new java.util.Random(42);
        System.out.println("Running experiment for sizes 20, 50, 100, 500...");
        System.out.printf("%-12s %-8s %-15s %-15s%n", "Algorithm", "Size", "Comparisons", "Time (ns)");

        for (int size : sizes) {
            int[] original = new int[size];
            for (int i = 0; i < size; i++) original[i] = r.nextInt(1000);

            runAndPrint("Selection", original.clone(), "selection");
            runAndPrint("Insertion", original.clone(), "insertion");
            runAndPrint("Merge",     original.clone(), "merge");
            runAndPrint("Quick",     original.clone(), "quick");
        }
    }

    static void runAndPrint(String name, int[] arr, String type) {
        long start = System.nanoTime();
        long comps = 0;
        switch (type) {
            case "selection": SortingAlgorithms.selectionSort(arr); comps = SortingAlgorithms.selectionComparisons; break;
            case "insertion": SortingAlgorithms.insertionSort(arr); comps = SortingAlgorithms.insertionComparisons; break;
            case "merge":     SortingAlgorithms.mergeSort(arr);     comps = SortingAlgorithms.mergeComparisons;     break;
            case "quick":     SortingAlgorithms.quickSort(arr);     comps = SortingAlgorithms.quickComparisons;     break;
        }
        long elapsed = System.nanoTime() - start;
        System.out.printf("%-12s %-8d %-15d %-15d%n", name, arr.length, comps, elapsed);
    }
}
