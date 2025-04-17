package Stack1;

import java.util.LinkedList;
import java.util.Queue;


public class BinTree<E extends Comparable<E>> {
    private static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;
        
        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node<E> root;
    private int size;
    
    public BinTree() {
        this.root = null;
        this.size = 0;
    }
    
    
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("Cannot add null element");
        }
        
        if (contains(element)) {
            return false;
        }
        
        root = addRecursive(root, element);
        size++;
        return true;
    }
    
    private Node<E> addRecursive(Node<E> current, E element) {
        if (current == null) {
            return new Node<>(element);
        }
        
        if (element.compareTo(current.data) < 0) {
            current.left = addRecursive(current.left, element);
        } else if (element.compareTo(current.data) > 0) {
            current.right = addRecursive(current.right, element);
        }
        
        return current;
    }
    
    
    public boolean contains(E element) {
        return containsRecursive(root, element);
    }
    
    private boolean containsRecursive(Node<E> current, E element) {
        if (current == null) {
            return false;
        }
        
        if (element.compareTo(current.data) == 0) {
            return true;
        }
        
        return element.compareTo(current.data) < 0
            ? containsRecursive(current.left, element)
            : containsRecursive(current.right, element);
    }
    
    
    public boolean remove(E element) {
        if (!contains(element)) {
            return false;
        }
        
        root = removeRecursive(root, element);
        size--;
        return true;
    }
    
    private Node<E> removeRecursive(Node<E> current, E element) {
        if (current == null) {
            return null;
        }
        
        if (element.compareTo(current.data) == 0) {
            
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            
            
            current.data = findMinValue(current.right);
            current.right = removeRecursive(current.right, current.data);
        } else if (element.compareTo(current.data) < 0) {
            current.left = removeRecursive(current.left, element);
        } else {
            current.right = removeRecursive(current.right, element);
        }
        
        return current;
    }
    
    private E findMinValue(Node<E> node) {
        return node.left == null ? node.data : findMinValue(node.left);
    }
    
    
    public int size() {
        return size;
    }
    
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    
    public void clear() {
        root = null;
        size = 0;
    }
    
    

public String inOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root, sb);
        return sb.toString().trim();
    }
    
    private void inOrderTraversal(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrderTraversal(node.left, sb);
            sb.append(node.data).append(" ");
            inOrderTraversal(node.right, sb);
        }
    }
    
    
    public String levelOrderTraversal() {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node<E> node = queue.remove();
            sb.append(node.data).append(" ");
            
            if (node.left != null) {
                queue.add(node.left);
            }
            
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        
        return sb.toString().trim();
    }
    
    
    public static void main(String[] args) {
        BinTree<Integer> tree = new BinTree<>();
        
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        
        
        System.out.println("In-order traversal: " + tree.inOrderTraversal());
        System.out.println("Level-order traversal: " + tree.levelOrderTraversal());
        System.out.println("Size: " + tree.size());
        System.out.println("Contains 4: " + tree.contains(4));
        System.out.println("Contains 10: " + tree.contains(10));
        
        
        System.out.println("Remove 3: " + tree.remove(3));
        System.out.println("In-order traversal after removal: " + tree.inOrderTraversal());
        
        
        tree.clear();
        System.out.println("Is empty after clear: " + tree.isEmpty());
    }
}