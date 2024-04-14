package proje;
import java.util.Arrays;
import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    
    CircularLinkedList() {
        head = null;
    }

   
    void append(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    
    void printList() {
        if (head == null) {
            System.out.println("Liste boş.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != head) {
                System.out.print(", ");
            }
        } while (temp != head);
        System.out.println();
    }
}

public class Ciruclar_linked_list {
    public static void main(String[] args) {
        CircularLinkedList[] lists = new CircularLinkedList[5]; 

        
        try (Scanner scanner = new Scanner(System.in)) {
			for (int i = 0; i < 5; i++) {
			    System.out.println("Listenin elemanlarını girin (virgülle ayırarak): ");
			    String input = scanner.nextLine();
			    String[] elements = input.split(",");
			    lists[i] = new CircularLinkedList();

			   
			    if (elements.length == 1 && elements[0].trim().isEmpty()) {
			        System.out.println("Liste boş.");
			    } else {
			        for (String element : elements) {
			            lists[i].append(element.trim());
			        }
			    }
			}
		}
        String[] allElements = new String[0];
        for (int i = 0; i < 5; i++) {
            if(lists[i].head != null) { 
                Node temp = lists[i].head;
                do {
                    allElements = Arrays.copyOf(allElements, allElements.length + 1);
                    allElements[allElements.length - 1] = temp.data;
                    temp = temp.next;
                } while (temp != lists[i].head);
            }
        }

       
        Arrays.sort(allElements);
        System.out.println("Sıralanmış Elemanlar:");
        for (String element : allElements) {
            System.out.print(element + " ");
        }
    }
}
