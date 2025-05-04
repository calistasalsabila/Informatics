public class ArrayListManual {
    private int[] arr;
    private int size;

    public ArrayListManual(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    public void append(int value) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = value;
    }

    public void prepend(int value) {
        if (size == arr.length) {
            resize();
        }
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = value;
        size++;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size)
            return;
        if (size == arr.length)
            resize();
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            return;
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    private void resize() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        return arr[index];
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        ArrayListManual myList = new ArrayListManual(5);

        // Menambah elemen menggunakan append
        myList.append(10);
        myList.append(20);
        myList.append(30);

        // Menambah elemen di depan menggunakan prepend
        myList.prepend(5);

        // Menambah elemen pada indeks tertentu menggunakan insert
        myList.insert(2, 15);

        // Mencetak list setelah operasi
        System.out.println("List setelah append, prepend, dan insert:");
        myList.printList();

        // Menghapus elemen pada indeks tertentu
        myList.remove(2);

        // Mencetak list setelah penghapusan
        System.out.println("List setelah remove:");
        myList.printList();

        // Mendapatkan elemen pada indeks tertentu
        System.out.println("Elemen di indeks 1: " + myList.get(1));

        // Mendapatkan ukuran list
        System.out.println("Ukuran list: " + myList.getSize());
    }
}
