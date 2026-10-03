class Student {
    int studentNo;
    String name;
    String serviceType;
    int serviceTime;

    Student(int studentNo, String name, String serviceType, int serviceTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
    }

    void display() {
        System.out.println(
            studentNo + " | " +
            name + " | " +
            serviceType + " | " +
            serviceTime + " minutes"
        );
    }
}


class Node {
    Student data;
    Node next;

    Node(Student data) {
        this.data = data;
        this.next = null;
    }
}


class StudentLinkedList {

    private Node head;

    StudentLinkedList() {
        head = null;
    }


    // Insert at the beginning
    void insertAtBeginning(Student student) {

        Node newNode = new Node(student);

        newNode.next = head;
        head = newNode;

        System.out.println(student.name + " inserted at beginning.");
    }


    // Insert at the end
    void insertAtEnd(Student student) {

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
            System.out.println(student.name + " inserted at end.");
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        System.out.println(student.name + " inserted at end.");
    }


    // Insert at a specific position
    void insertAtPosition(Student student, int position) {

        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            insertAtBeginning(student);
            return;
        }

        Node newNode = new Node(student);
        Node current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position does not exist.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;

        System.out.println(
            student.name + " inserted at position " + position + "."
        );
    }


    // Delete a student using student number
    void deleteStudent(int studentNo) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If the student is the first node
        if (head.data.studentNo == studentNo) {

            System.out.println(head.data.name + " deleted.");

            head = head.next;
            return;
        }

        Node current = head;

        while (
            current.next != null &&
            current.next.data.studentNo != studentNo
        ) {
            current = current.next;
        }

        // Student was not found
        if (current.next == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println(current.next.data.name + " deleted.");

        // Remove the node
        current.next = current.next.next;
    }


    // Search for a student
    Student searchStudent(int studentNo) {

        Node current = head;

        while (current != null) {

            if (current.data.studentNo == studentNo) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }


    // Display all students
    void displayStudents() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;

        while (current != null) {

            current.data.display();

            current = current.next;
        }
    }
}


public class main {

    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();


        // Create students
        Student s1 = new Student(
            221045678,
            "Maria",
            "Registration",
            12
        );

        Student s2 = new Student(
            222034512,
            "Tomas",
            "Student Card",
            5
        );

        Student s3 = new Student(
            223041876,
            "Ndapewa",
            "Fees",
            8
        );

        Student s4 = new Student(
            221067341,
            "Simon",
            "Documents",
            4
        );

        Student s5 = new Student(
            224056789,
            "Anna",
            "Academic",
            15
        );


        // ==========================================
        // INSERT AT BEGINNING
        // ==========================================

        System.out.println("===== INSERT AT BEGINNING =====");

        list.insertAtBeginning(s1);

        list.displayStudents();


        // ==========================================
        // INSERT AT END
        // ==========================================

        System.out.println();
        System.out.println("===== INSERT AT END =====");

        list.insertAtEnd(s2);
        list.insertAtEnd(s3);

        list.displayStudents();


        // ==========================================
        // INSERT AT POSITION 3
        // ==========================================

        System.out.println();
        System.out.println("===== INSERT AT POSITION 3 =====");

        list.insertAtPosition(s4, 3);

        list.displayStudents();


        // ==========================================
        // INSERT ANOTHER STUDENT AT END
        // ==========================================

        System.out.println();
        System.out.println("===== INSERT ANOTHER STUDENT =====");

        list.insertAtEnd(s5);

        list.displayStudents();


        // ==========================================
        // SEARCH STUDENT
        // ==========================================

        System.out.println();
        System.out.println("===== SEARCH STUDENT =====");

        Student found = list.searchStudent(223041876);

        if (found != null) {

            System.out.println("Student found:");
            found.display();

        } else {

            System.out.println("Student not found.");
        }


        // ==========================================
        // DELETE STUDENT
        // ==========================================

        System.out.println();
        System.out.println("===== DELETE STUDENT =====");

        list.deleteStudent(221067341);


        // ==========================================
        // DISPLAY AFTER DELETE
        // ==========================================

        System.out.println();
        System.out.println("===== LIST AFTER DELETE =====");

        list.displayStudents();
    }
}