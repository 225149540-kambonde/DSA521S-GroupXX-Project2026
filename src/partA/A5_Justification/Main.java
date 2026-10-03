public class Main {

    public static void main(String[] args) {

        System.out.println("===== A5: DATA STRUCTURE JUSTIFICATION =====");
        System.out.println();


        // ARRAY
        System.out.println("1. ARRAY");

        System.out.println(
                "An array is appropriate for storing the service times "
                + "of students because the number of values can be stored "
                + "in a simple indexed structure."
        );

        System.out.println(
                "It allows the program to easily access each service time "
                + "and calculate the total, average, highest and lowest "
                + "service times."
        );

        System.out.println();


        // SINGLY LINKED LIST
        System.out.println("2. SINGLY LINKED LIST");

        System.out.println(
                "A singly linked list is appropriate for storing student "
                + "service records because each student is stored in a node."
        );

        System.out.println(
                "Each node contains the student's information and a link "
                + "to the next student."
        );

        System.out.println(
                "Students can be inserted or deleted without moving all "
                + "the other records."
        );

        System.out.println();


        // QUEUE
        System.out.println("3. QUEUE");

        System.out.println(
                "A queue is appropriate for managing students waiting "
                + "for service because students should normally be served "
                + "in the order they arrive."
        );

        System.out.println(
                "The queue follows FIFO, which means First In, First Out."
        );

        System.out.println(
                "The first student to join the queue is therefore the "
                + "first student to be served."
        );

        System.out.println();


        // STACK
        System.out.println("4. STACK");

        System.out.println(
                "A stack is appropriate for evaluating postfix "
                + "expressions because it follows LIFO, which means "
                + "Last In, First Out."
        );

        System.out.println(
                "Numbers are pushed onto the stack and operands are "
                + "popped when an operator is encountered."
        );

        System.out.println(
                "The calculated result is then pushed back onto the stack."
        );

        System.out.println();


        System.out.println("===== END OF JUSTIFICATION =====");
    }
}