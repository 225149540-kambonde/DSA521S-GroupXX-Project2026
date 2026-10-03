class Stack {

    int[] stack;
    int top;

    // Constructor
    Stack(int size) {
        stack = new int[size];
        top = -1;
    }

    // PUSH operation
    void push(int value) {

        if (top == stack.length - 1) {
            System.out.println("Stack is full.");
            return;
        }

        top++;
        stack[top] = value;
    }

    // POP operation
    int pop() {

        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        }

        int value = stack[top];
        top--;

        return value;
    }

    // PEEK operation
    int peek() {

        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        }

        return stack[top];
    }

    // Display stack
    void display() {

        if (top == -1) {
            System.out.println("Stack: [empty]");
            return;
        }

        System.out.print("Stack: [");

        for (int i = 0; i <= top; i++) {

            System.out.print(stack[i]);

            if (i < top) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}


public class Main {

    public static void main(String[] args) {

        Stack stack = new Stack(10);

        System.out.println("===== A3: POSTFIX EXPRESSION EVALUATION =====");
        System.out.println("Expression: 5 3 + 2 *");
        System.out.println();


        // STEP 1: Push 5
        System.out.println("Step 1: Push 5");

        stack.push(5);

        stack.display();

        System.out.println();


        // STEP 2: Push 3
        System.out.println("Step 2: Push 3");

        stack.push(3);

        stack.display();

        System.out.println();


        // STEP 3: Perform addition
        System.out.println("Step 3: Operator +");

        int secondOperand = stack.pop();
        int firstOperand = stack.pop();

        int result = firstOperand + secondOperand;

        System.out.println(
            firstOperand + " + " + secondOperand + " = " + result
        );

        stack.push(result);

        stack.display();

        System.out.println();


        // STEP 4: Push 2
        System.out.println("Step 4: Push 2");

        stack.push(2);

        stack.display();

        System.out.println();


        // STEP 5: Perform multiplication
        System.out.println("Step 5: Operator *");

        secondOperand = stack.pop();
        firstOperand = stack.pop();

        result = firstOperand * secondOperand;

        System.out.println(
            firstOperand + " * " + secondOperand + " = " + result
        );

        stack.push(result);

        stack.display();

        System.out.println();


        // STEP 6: Get final result using PEEK
        System.out.println("===== FINAL RESULT =====");

        int finalResult = stack.peek();

        System.out.println("Final result = " + finalResult);
    }
}