package stack1;



class Stack {
    private int top;
    private int[] items;
    private int size;

    public Stack(int size) {
        this.size = size;
        this.items = new int[size];
        this.top = -1;
    }

    public void push(int item) {
        if (top < size - 1) {
            items[++top] = item;
        } else {
            System.out.println("Стек переполнен!");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Стек пуст!");
            return -1; 
        } else {
            return items[top--];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Стек пуст!");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(items[i]);
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10); 
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Стек после добавления элементов:");
        stack.display();

        System.out.println("Извлеченный элемент: " + stack.pop());

        System.out.println("Стек после извлечения элемента:");
        stack.display();
    }
}