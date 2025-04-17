package Stack1;

public class list<E> {
    
    private static class Node<E> {
        E data;
        Node<E> next;
        
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<E> head;
    private int size;
    
    public list() {
        this.head = null;
        this.size = 0;
    }
    
    
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    
    public void print() {
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    
    public int size() {
        return size;
    }
    
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    
    public static void main(String[] args) {
        list<Integer> myList = new list<>();
        
        
        myList.add(1);
        myList.add(2);
        myList.add(3);
        
        
        System.out.println("Содержимое списка:");
        myList.print();
        
        
        System.out.println("Размер списка: " + myList.size());
        
        
        System.out.println("Список пустой? " + myList.isEmpty());
    }
}