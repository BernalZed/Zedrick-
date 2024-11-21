
package stacksmain;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackClass {
    private Node top;

    public StackClass() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        Node current = top;
        System.out.print("Stack elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class StacksMain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StackClass stack = new StackClass();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("0: Exit");
            System.out.println("1: Push an element");
            System.out.println("2: Pop an element");
            System.out.println("3: Peek the top element");
            System.out.println("4: Display the stack");
            System.out.print("Input: ");
            int choice = scn.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    exit = true;
                    break;

                case 1:
                    System.out.print("Enter an element to push: ");
                    int value = scn.nextInt();
                    stack.push(value);
                    System.out.println(value + " pushed to the stack.");
                    break;

                case 2:
                    int poppedValue = stack.pop();
                    if (poppedValue != -1) {
                        System.out.println("Popped element: " + poppedValue);
                    }
                    break;

                case 3:
                    int topValue = stack.peek();
                    if (topValue != -1) {
                        System.out.println("Top element: " + topValue);
                    }
                    break;

                case 4:
                    stack.display();
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }

        scn.close();
    }
}
