
package Stack1;

import java.util.NoSuchElementException;


public class queue<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<E> front;
    private Node<E> rear;
    private int size;
    
    public queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    
    public boolean enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        
        rear = newNode;
        size++;
        return true;
    }
    
   
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        E element = front.data;
        front = front.next;
        
        if (front == null) {
            rear = null;
        }
        
        size--;
        return element;
    }
    
    
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }
    
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    
    public int size() {
        return size;
    }
    
    
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
    
    
    public static void main(String[] args) {
        queue<String> q = new queue<>();
        
        q.enqueue("First");
        q.enqueue("Second");
        q.enqueue("Third");
        
        System.out.println("Queue size: " + q.size());
        System.out.println("Peek: " + q.peek());
        
        while (!q.isEmpty()) {
            System.out.println("Dequeued: " + q.dequeue());
        }
        
        System.out.println("Queue is empty: " + q.isEmpty());
    }
}