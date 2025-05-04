class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println("Queue = " + temp.value);
            temp = temp.next;
        }
    }

    public void getFirst() {
        System.out.println("first = " + first.value);
    }

    public void getLast() {
        System.out.println("last = " + last.value);
    }

    public void getLength() {
        System.out.println("length = " + length);
    }

    // Fungsi untuk menambah elemen dari belakang
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    // Fungsi untuk mengambil yang paling depan atau menghapus elemen dari depan
    public Node dequeue() {
        if (length == 0) {
            return null;
        }
        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    // Fungsi untuk melihat elemen paling depan
    public Node peek() {
        if (length == 0) {
            return null;
        } else {
            return first;
        }

    }
}