class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

public class Stack {
    private Node top;
    private int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    // Fungsi untuk print Stack
    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.value);
            temp = temp.next;

        }
    }

    public void getTop() {
        System.out.println("Top =  " + top.value);
    }

    public void getHeight() {
        System.out.println("Height =  " + height);
    }

    // Fungsi untuk menambah stack (stack cm bisa di tambah dari top aja)
    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    // Fungsi untuk mengambil stack
    public Node pop() {
        if (height == 0) {
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    public static void main(String[] args) {    
        Stack myStack = new Stack(2);

        myStack.getTop();

        myStack.printStack();
    }
}