public class StackManual {
    private int[] arr;
    private int top;

    public StackManual(int capacity) {
        arr = new int[capacity];
        top = -1; // stack kosong
    }

    // push: tambah elemen ke stack
    public void push(int value) {
        if (top == arr.length - 1) {
            System.out.println("Stack penuh! Tidak bisa push.");
            return;
        }
        arr[++top] = value;
    }

    // pop: hapus dan kembalikan elemen paling atas
    public int pop() {
        if (top == -1) {
            System.out.println("Stack kosong! Tidak bisa pop.");
            return -1; // nilai default jika kosong
        }
        return arr[top--];
    }

    // peek: lihat elemen paling atas tanpa menghapus
    public int peek() {
        if (top == -1) {
            System.out.println("Stack kosong!");
            return -1;
        }
        return arr[top];
    }

    // cek apakah stack kosong
    public boolean isEmpty() {
        return top == -1;
    }

    // ukuran stack (jumlah elemen)
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackManual stack = new StackManual(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Elemen paling atas: " + stack.peek());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Apakah stack kosong? " + stack.isEmpty());

        stack.push(40);
        System.out.println("Elemen paling atas setelah push 40: " + stack.peek());
    }
}