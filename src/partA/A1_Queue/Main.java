class Student {
    long studentNo;
    String name;
    String serviceType;
    int serviceTime;

    Student(long studentNo, String name, String serviceType, int serviceTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
    }

    void display() {
        System.out.println(studentNo + " | " + name + " | " + serviceType + " | " + serviceTime + " minutes");
    }
}

class ArrayQueue {
    private Student[] items;
    private int front, rear, size, capacity;

    ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.items = new Student[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    boolean isEmpty() { return size == 0; }
    boolean isFull()  { return size == capacity; }

    void enqueue(Student s) {
        if (isFull()) { System.out.println("Queue is full."); return; }
        rear = (rear + 1) % capacity;
        items[rear] = s;
        size++;
        System.out.println(s.name + " joined the queue.");
    }

    Student dequeue() {
        if (isEmpty()) { System.out.println("Queue is empty."); return null; }
        Student served = items[front];
        items[front] = null;
        front = (front + 1) % capacity;
        size--;
        return served;
    }

    Student peek() {
        if (isEmpty()) return null;
        return items[front];
    }

    void displayQueue() {
        if (isEmpty()) { System.out.println("Queue is empty."); return; }
        for (int i = 0; i < size; i++) {
            items[(front + i) % capacity].display();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(10);

        Student maria    = new Student(221045678L, "Maria",    "Registration", 12);
        Student tomas    = new Student(222034512L, "Tomas",    "Student Card",  5);
        Student ndapewa  = new Student(223041876L, "Ndapewa",  "Fees",          8);
        Student simon    = new Student(221067341L, "Simon",    "Documents",     4);
        Student anna     = new Student(224056789L, "Anna",     "Academic",     15);
        Student david    = new Student(225078912L, "David",    "Registration",  7);

        System.out.println("STUDENT ARRIVALS");
        q.enqueue(maria); q.enqueue(tomas); q.enqueue(ndapewa);
        q.enqueue(simon); q.enqueue(anna);  q.enqueue(david);

        System.out.println("\nWAITING QUEUE");
        q.displayQueue();

        System.out.println("\nFRONT STUDENT");
        q.peek().display();

        System.out.println("\nSTUDENTS BEING SERVED");
        q.dequeue().display();
        q.dequeue().display();
        q.dequeue().display();

        System.out.println("\nREMAINING QUEUE");
        q.displayQueue();

        System.out.println("\nIs queue empty? " + q.isEmpty());
    }
}