public class Main {

    public static void main(String[] args) {

        // Array storing service times of students served
        int[] serviceTimes = {12, 5, 8, 4, 15, 7};

        int totalStudents = serviceTimes.length;

        int totalServiceTime = 0;
        int highest = serviceTimes[0];
        int lowest = serviceTimes[0];
        int countAbove10 = 0;


        // Calculate total, highest, lowest and count above 10
        for (int i = 0; i < serviceTimes.length; i++) {

            // Calculate total service time
            totalServiceTime = totalServiceTime + serviceTimes[i];

            // Find highest service time
            if (serviceTimes[i] > highest) {
                highest = serviceTimes[i];
            }

            // Find lowest service time
            if (serviceTimes[i] < lowest) {
                lowest = serviceTimes[i];
            }

            // Count service times greater than 10
            if (serviceTimes[i] > 10) {
                countAbove10++;
            }
        }


        // Calculate average
        double averageServiceTime =
                (double) totalServiceTime / totalStudents;


        // Display results
        System.out.println("===== A4: ARRAY SERVICE-TIME STATISTICS =====");

        System.out.println();

        System.out.println("Service times:");

        for (int i = 0; i < serviceTimes.length; i++) {
            System.out.println(
                    "Student " + (i + 1) +
                    ": " + serviceTimes[i] + " minutes"
            );
        }

        System.out.println();

        System.out.println("Total students served: " + totalStudents);

        System.out.println(
                "Total service time: " +
                totalServiceTime + " minutes"
        );

        System.out.println(
                "Average service time: " +
                averageServiceTime + " minutes"
        );

        System.out.println(
                "Highest service time: " +
                highest + " minutes"
        );

        System.out.println(
                "Lowest service time: " +
                lowest + " minutes"
        );

        System.out.println(
                "Students with service time greater than 10 minutes: " +
                countAbove10
        );
    }
}