
package queueusingtwostacks;

import java.util.Stack;
import java.util.Scanner;

class QueueUsingTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int data) {
        stack1.push(data);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1; 
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void display() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        Stack<Integer> tempStack2 = (Stack<Integer>) stack2.clone();
        while (!tempStack2.isEmpty()) {
            System.out.print(tempStack2.pop() + " ");
        }

        Stack<Integer> tempStack1 = (Stack<Integer>) stack1.clone();
        while (!tempStack1.isEmpty()) {
            System.out.print(tempStack1.pop() + " ");
        }

        System.out.println();
    }
}

public class QueueUsingTwoStacksMain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("0: Exit");
            System.out.println("1: Enqueue an element");
            System.out.println("2: Dequeue an element");
            System.out.println("3: Display the queue");
            System.out.print("Input: ");
            int choice = scn.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exit!");
                    scn.close();
                    return;

                case 1:
                    System.out.print("Enter an element to enqueue: ");
                    int value = scn.nextInt();
                    queue.enqueue(value);
                    System.out.println(value + " enqueued to the queue.");
                    break;

                case 2:
                    int dequeuedValue = queue.dequeue();
                    if (dequeuedValue != -1) {
                        System.out.println("Dequeued element: " + dequeuedValue);
                    }
                    break;

                case 3:
                    queue.display();
                    break;

                default:
                    System.out.println("Invalid, please try another one!");
                    break;
            }
        }
    }
}