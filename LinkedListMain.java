
package singlylinkedlistmain;

class Node {
    int data;        
    Node next;       

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;  

    public LinkedList() {
        head = null;  
    }

    public void addToEnd(int data) {
        Node newNode = new Node(data);  

        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void reverseList() {
        Node previousNode = null;  
        Node currentNode = head;  
        Node nextNode = null;  

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        head = previousNode;
    }
}

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);
        list.addToEnd(40);

        System.out.println("List Before Reversing");
        list.printList();

        list.reverseList();

        System.out.println("List After Reversing");
        list.printList();
    }
}
