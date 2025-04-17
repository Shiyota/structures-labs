/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack1;

import java.util.NoSuchElementException;

/**
 *
 * @author YourName
 */
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
    
    /**
     * Добавляет элемент в конец очереди
     * @param element элемент для добавления
     * @return true если элемент успешно добавлен
     */
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
    
    /**
     * Удаляет и возвращает элемент из начала очереди
     * @return элемент из начала очереди
     * @throws NoSuchElementException если очередь пуста
     */
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
    
    /**
     * Возвращает элемент из начала очереди без удаления
     * @return элемент из начала очереди
     * @throws NoSuchElementException если очередь пуста
     */
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }
    
    /**
     * Проверяет, пуста ли очередь
     * @return true если очередь пуста
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Возвращает количество элементов в очереди
     * @return количество элементов
     */
    public int size() {
        return size;
    }
    
    /**
     * Очищает очередь
     */
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
    
    /**
     * Пример использования очереди
     */
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