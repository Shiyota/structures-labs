package main;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next= null;
    }
}
class LinkedList{
    Node head;
    void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    void printList(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
public class Main {
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.printList();
    }
}
