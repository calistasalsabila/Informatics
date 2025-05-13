import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi struktur data
        BinaryTree isbnTree = new BinaryTree();
        ISBNSet isbnSet = new ISBNSet();
        BookList bookList = new BookList();
        BookStack returnStack = new BookStack();
        BorrowerMap borrowerMap = new BorrowerMap();
        BorrowQueue borrowQueue = new BorrowQueue();
        CatalogTreeMap catalog = new CatalogTreeMap();

        System.out.println("=== Aplikasi Manajemen Perpustakaan ===");

        mainLoop: while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Cari Buku (berdasarkan ISBN)");
            System.out.println("3. Tampilkan Semua Buku");
            System.out.println("4. Pinjam Buku");
            System.out.println("5. Kembalikan Buku");
            System.out.println("6. Lihat Riwayat Pengembalian");
            System.out.println("7. Tampilkan Daftar Peminjam Aktif");
            System.out.println("8. Tampilkan Antrean Peminjam");
            System.out.println("9. Tampilkan Katalog Berdasarkan Genre");
            System.out.println("10. Cari Buku Berdasarkan Genre");
            System.out.println("11. Hapus Buku");
            System.out.println("12. Tampilkan ISBN Dalam Tree (in-order)");
            System.out.println("13. Keluar");
            System.out.print("Pilih menu (1-13): ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1": // Tambah Buku
                        System.out.print("Masukkan ISBN: ");
                        String isbn = scanner.nextLine().trim();

                        if (!isbnSet.addISBN(isbn)) {
                            // ISBN sudah ada, skip tambah buku
                            break;
                        }

                        System.out.print("Masukkan Judul: ");
                        String title = scanner.nextLine().trim();

                        System.out.print("Masukkan Genre: ");
                        String genre = scanner.nextLine().trim();

                        Book book = new Book(isbn, title, genre);
                        bookList.addBook(book);
                        catalog.addBook(book);
                        isbnTree.insert(isbn);
                        System.out.println("Buku berhasil ditambahkan.");
                        break;

                    case "2": // Cari Buku by ISBN
                        System.out.print("Masukkan ISBN yang dicari: ");
                        String searchIsbn = scanner.nextLine().trim();
                        if (isbnTree.search(searchIsbn)) {
                            Book found = bookList.getBookByISBN(searchIsbn);
                            if (found != null) {
                                System.out.println("Detail Buku: " + found);
                            } else {
                                System.out.println("Buku ditemukan di Tree ISBN, tapi tidak ada di daftar buku.");
                            }
                        }
                        break;

                    case "3": // Tampilkan Semua Buku
                        bookList.showAllBooks();
                        break;

                    case "4": // Pinjam Buku
                        System.out.print("Masukkan ID Peminjam: ");
                        String borrowerId = scanner.nextLine().trim();
                        System.out.print("Masukkan ISBN Buku yang ingin dipinjam: ");
                        String borrowIsbn = scanner.nextLine().trim();

                        if (!isbnSet.contains(borrowIsbn)) {
                            System.out.println("ISBN tidak valid, buku tidak ditemukan.");
                            break;
                        }

                        if (borrowerMap.isBorrowing(borrowerId)) {
                            System.out.println("Peminjam ini sudah meminjam buku.");
                            break;
                        }

                        if (borrowQueue.isEmpty()) {
                            try {
                                borrowerMap.borrow(borrowerId, borrowIsbn);
                            } catch (Exception e) {
                                System.out.println("Gagal meminjam: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Ada antrean peminjam, Anda akan dimasukkan ke antrean.");
                            borrowQueue.addToQueue(borrowerId);
                        }
                        break;

                    case "5": // Kembalikan Buku
                        System.out.print("Masukkan ID Peminjam: ");
                        String returnerId = scanner.nextLine().trim();

                        String returnedIsbn = borrowerMap.returnBook(returnerId);
                        if (returnedIsbn != null) {
                            returnStack.push(returnedIsbn);

                            // Jika ada orang antrean, proses mereka untuk pinjam buku
                            if (!borrowQueue.isEmpty()) {
                                String nextBorrowerId = borrowQueue.processQueue();
                                try {
                                    borrowerMap.borrow(nextBorrowerId, returnedIsbn);
                                    System.out.println(
                                            "Buku dipinjamkan ke peminjam antrean berikutnya: " + nextBorrowerId);
                                } catch (Exception e) {
                                    System.out.println("Gagal memproses peminjam antrean: " + e.getMessage());
                                }
                            }
                        }
                        break;

                    case "6": // Lihat Riwayat Pengembalian
                        returnStack.showAllReturned();
                        break;

                    case "7": // Tampilkan Peminjam Aktif
                        borrowerMap.showBorrowers();
                        break;

                    case "8": // Tampilkan Antrean Peminjam
                        borrowQueue.showQueue();
                        break;

                    case "9": // Tampilkan Katalog
                        catalog.showCatalog();
                        break;

                    case "10": // Cari Buku Berdasarkan Genre
                        System.out.print("Masukkan Genre yang dicari: ");
                        String g = scanner.nextLine().trim();
                        catalog.searchByGenre(g);
                        break;

                    case "11": // Hapus Buku
    System.out.print("Masukkan Genre Buku yang akan dihapus: ");
    String delGenre = scanner.nextLine().trim();
    System.out.print("Masukkan ISBN Buku yang akan dihapus: ");
    String delIsbn = scanner.nextLine().trim();

    catalog.removeBook(delGenre, delIsbn);
    bookList.removeBookByISBN(delIsbn);
    isbnSet.removeISBN(delIsbn);       // DULUNYA: cuma contains() doang
    isbnTree.delete(delIsbn);          // Tambahan fitur delete di BinaryTree
    break;


                    case "12": // Tampilkan ISBN dalam BinaryTree (in-order)
                        isbnTree.printInOrder();
                        break;

                    case "13": // Out
                        System.out.println("Terima kasih!!.");
                        break mainLoop;

                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih nomor menu yang tersedia.");
                        break;
                }
            } catch (InvalidInputException e) {
                System.out.println("Input tidak valid: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

public class BinaryTree {
    private Node root;

    private static class Node {
        String isbn;
        Node left, right;

        Node(String isbn) {
            this.isbn = isbn;
        }
    }

    // Menambahkan ISBN ke tree
    public void insert(String isbn) {
        root = insertRec(root, isbn);
        System.out.println("ISBN " + isbn + " berhasil dimasukkan ke dalam binary Tree.");
    }

    private Node insertRec(Node current, String isbn) {
        if (current == null) {
            return new Node(isbn);
        }

        int cmp = isbn.compareTo(current.isbn);
        if (cmp < 0) {
            current.left = insertRec(current.left, isbn);
        } else if (cmp > 0) {
            current.right = insertRec(current.right, isbn);
        } // else do nothing kalau duplikat
        return current;
    }

    // Menghapus ISBN dari BinaryTree
public void delete(String isbn) {
    root = deleteRec(root, isbn);
    System.out.println("ISBN " + isbn + " telah dihapus dari binary tree.");
}

private Node deleteRec(Node node, String isbn) {
    if (node == null) return null;

    int cmp = isbn.compareTo(node.isbn);
    if (cmp < 0) {
        node.left = deleteRec(node.left, isbn);
    } else if (cmp > 0) {
        node.right = deleteRec(node.right, isbn);
    } else {
        // Node ditemukan
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;

        // Node dengan dua anak: cari pengganti dari subtree kanan (min)
        Node min = findMin(node.right);
        node.isbn = min.isbn;
        node.right = deleteRec(node.right, min.isbn);
    }

    return node;
}

private Node findMin(Node node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}


    // Mencari ISBN di tree
    public boolean search(String isbn) {
        boolean found = searchRec(root, isbn);
        System.out.println(found ? "ISBN ditemukan di binary tree." : "ISBN tidak ditemukan di binary tree.");
        return found;
    }

    private boolean searchRec(Node current, String isbn) {
        if (current == null)
            return false;
        int cmp = isbn.compareTo(current.isbn);
        if (cmp == 0)
            return true;
        return cmp < 0 ? searchRec(current.left, isbn) : searchRec(current.right, isbn);
    }

    // Optional: Cetak semua ISBN in-order (urut)
    public void printInOrder() {
        System.out.println("Daftar ISBN dalam binary tree (in-order):");
        printInOrderRec(root);
    }

    private void printInOrderRec(Node node) {
        if (node != null) {
            printInOrderRec(node.left);
            System.out.println(" - " + node.isbn);
            printInOrderRec(node.right);
        }
    }
}
 
public class Book {
    private final String isbn;
    private final String title;
    private final String genre;

    public Book(String isbn, String title, String genre) throws InvalidInputException {
        if (isbn == null || isbn.isEmpty())
            throw new InvalidInputException("ISBN tidak boleh kosong");
        if (title == null || title.isEmpty())
            throw new InvalidInputException("Judul tidak boleh kosong");
        if (genre == null || genre.isEmpty())
            throw new InvalidInputException("Genre tidak boleh kosong");

        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return String.format("📖 Judul: %s | ISBN: %s | Genre: %s", title, isbn, genre);
    }
}

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("Buku tidak boleh null");
        books.add(book);
    }

    public void removeBookByISBN(String isbn) {
        books.removeIf(b -> b.getIsbn().equals(isbn));
    }

    public Book getBookByISBN(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn))
                return b;
        }
        return null;
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku yang tersedia.");
            return;
        }

        System.out.println("Daftar Buku:");
        for (Book book : books) {
            System.out.println("  " + book);
        }
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public List<Book> getAllBooks() {
        return books;
    }
}

import java.util.Stack;

public class BookStack {
    private final Stack<String> returnedBooks = new Stack<>();

    // Menambahkan ISBN ke stack saat buku dikembalikan
    public void push(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            System.out.println("ISBN tidak valid. Tidak bisa dimasukkan ke riwayat pengembalian.");
            return;
        }
        returnedBooks.push(isbn);
        System.out.println("ISBN " + isbn + " ditambahkan ke riwayat pengembalian.");
    }

    // Melihat ISBN paling atas (buku terakhir dikembalikan)
    public String peek() {
        if (returnedBooks.isEmpty()) {
            return "Riwayat pengembalian kosong.";
        }
        return returnedBooks.peek();
    }

    // Menghapus dan mengembalikan ISBN paling atas
    public String pop() {
        if (returnedBooks.isEmpty()) {
            System.out.println("Tidak ada buku untuk dihapus dari stack.");
            return null;
        }
        String isbn = returnedBooks.pop();
        System.out.println("ISBN " + isbn + " dikeluarkan dari riwayat.");
        return isbn;
    }

    // Mengecek apakah stack kosong
    public boolean isEmpty() {
        return returnedBooks.isEmpty();
    }

    // Menampilkan semua buku yang sudah dikembalikan (dari atas ke bawah)
    public void showAllReturned() {
        if (returnedBooks.isEmpty()) {
            System.out.println(" Belum ada buku yang dikembalikan.");
            return;
        }

        System.out.println("Riwayat Pengembalian (terbaru ke lama):");
        for (int i = returnedBooks.size() - 1; i >= 0; i--) {
            System.out.println(" - ISBN: " + returnedBooks.get(i));
        }
    }
}


import java.util.HashMap;
import java.util.Map;

public class BorrowerMap {
    private final Map<String, String> borrowerMap = new HashMap<>();

    // Meminjam buku
    public void borrow(String borrowerId, String isbn) {
        if (borrowerId == null || borrowerId.isBlank() || isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ID peminjam dan ISBN tidak boleh kosong.");
        }

        if (borrowerMap.containsKey(borrowerId)) {
            throw new IllegalStateException("ID ini sudah meminjam buku dengan ISBN: " + borrowerMap.get(borrowerId));
        }

        borrowerMap.put(borrowerId, isbn);
        System.out.println("Peminjam ID: " + borrowerId + " berhasil meminjam buku ISBN: " + isbn);
    }

    // Mengembalikan buku
    public String returnBook(String borrowerId) {
        if (!borrowerMap.containsKey(borrowerId)) {
            System.out.println("Peminjam dengan ID: " + borrowerId + " tidak ditemukan.");
            return null;
        }

        String isbn = borrowerMap.remove(borrowerId);
        System.out.println("Buku dengan ISBN: " + isbn + " dikembalikan oleh ID: " + borrowerId);
        return isbn;
    }

    // Menampilkan semua peminjam aktif
    public void showBorrowers() {
        if (borrowerMap.isEmpty()) {
            System.out.println("Tidak ada peminjam aktif saat ini.");
            return;
        }

        System.out.println(" Daftar Peminjam Aktif:");
        for (Map.Entry<String, String> entry : borrowerMap.entrySet()) {
            System.out.println(" - ID: " + entry.getKey() + " | ISBN: " + entry.getValue());
        }
    }

    // Mengecek apakah ID tertentu sedang meminjam buku
    public boolean isBorrowing(String borrowerId) {
        return borrowerMap.containsKey(borrowerId);
    }
}


import java.util.LinkedList;
import java.util.Queue;

public class BorrowQueue {
    private final Queue<String> queue = new LinkedList<>();

    // Menambahkan ID ke antrean
    public void addToQueue(String id) {
        if (id == null || id.isBlank()) {
            System.out.println("ID peminjam tidak valid. Tidak ditambahkan ke antrean.");
            return;
        }
        queue.add(id);
        System.out.println("ID " + id + " telah ditambahkan ke antrean.");
    }

    // Memproses peminjam pertama di antrean
    public String processQueue() {
        if (queue.isEmpty()) {
            System.out.println("Tidak ada peminjam dalam antrean.");
            return null;
        }
        String id = queue.poll();
        System.out.println("ID " + id + " telah diproses dari antrean.");
        return id;
    }

    // Menampilkan semua peminjam dalam antrean
    public void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("Antrean kosong.");
            return;
        }

        System.out.println("Daftar Antrean Peminjam:");
        for (String id : queue) {
            System.out.println(" - ID: " + id);
        }
    }

    // Mengecek apakah antrean kosong
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Mengembalikan ukuran antrean
    public int getSize() {
        return queue.size();
    }
}


import java.util.*;

public class CatalogTreeMap {
    private final TreeMap<String, List<Book>> catalog = new TreeMap<>();

    // Menambahkan buku ke katalog
    public void addBook(Book book) {
        if (book == null || book.getGenre() == null || book.getGenre().isBlank()) {
            System.out.println("Genre buku tidak boleh kosong.");
            return;
        }

        String genre = book.getGenre();
        catalog.computeIfAbsent(genre, k -> new ArrayList<>()).add(book);
        System.out.println("Buku '" + book.getTitle() + "' berhasil ditambahkan ke genre '" + genre + "'.");
    }

    // Menampilkan katalog
    public void showCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("Katalog masih kosong.");
            return;
        }

        System.out.println("Katalog Buku Berdasarkan Genre:");
        for (Map.Entry<String, List<Book>> entry : catalog.entrySet()) {
            System.out.println("\nGenre: " + entry.getKey());
            for (Book book : entry.getValue()) {
                System.out.println(" - " + book);
            }
        }
    }

    // Mencari buku berdasarkan genre
    public void searchByGenre(String genre) {
        if (!catalog.containsKey(genre)) {
            System.out.println("Genre '" + genre + "' tidak ditemukan dalam katalog.");
            return;
        }

        System.out.println("Buku dalam genre '" + genre + "':");
        for (Book book : catalog.get(genre)) {
            System.out.println(" - " + book);
        }
    }

    // Menghapus buku dari genre tertentu
    public void removeBook(String genre, String isbn) {
        if (!catalog.containsKey(genre)) {
            System.out.println("Genre tidak ditemukan.");
            return;
        }

        List<Book> books = catalog.get(genre);
        boolean removed = books.removeIf(book -> book.getIsbn().equals(isbn));

        if (removed) {
            System.out.println("Buku dengan ISBN " + isbn + " berhasil dihapus dari genre " + genre + ".");
            if (books.isEmpty()) {
                catalog.remove(genre);
                System.out.println("Genre '" + genre + "' kosong dan dihapus dari katalog.");
            }
        } else {
            System.out.println("Buku dengan ISBN tersebut tidak ditemukan di genre " + genre + ".");
        }
    }
}


public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}


import java.util.HashSet;
import java.util.Set;

public class ISBNSet {
    private Set<String> isbnSet = new HashSet<>();

    // Menambahkan ISBN jika belum ada
    public boolean addISBN(String isbn) {
        if (isbnSet.contains(isbn)) {
            System.out.println("ISBN \"" + isbn + "\" sudah ada di sistem.");
            return false;
        } else {
            isbnSet.add(isbn);
            System.out.println("ISBN \"" + isbn + "\" berhasil ditambahkan ke set.");
            return true;
        }
    }

    public void removeISBN(String isbn) {
    if (isbnSet.remove(isbn)) {
        System.out.println("ISBN \"" + isbn + "\" dihapus dari set.");
    } else {
        System.out.println("ISBN \"" + isbn + "\" tidak ditemukan di set.");
    }
}


    // Mengecek apakah ISBN sudah ada
    public boolean contains(String isbn) {
        boolean result = isbnSet.contains(isbn);
        System.out.println(result ? "ISBN ditemukan dalam set." : "ISBN tidak ditemukan dalam set.");
        return result;
    }

    // Menampilkan semua ISBN yang tersimpan
    public void displayAllISBNs() {
        System.out.println("Daftar ISBN dalam set:");
        if (isbnSet.isEmpty()) {
            System.out.println(" (Kosong)");
        } else {
            for (String isbn : isbnSet) {
                System.out.println(" - " + isbn);
            }
        }
    }
}

