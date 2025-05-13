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
                        isbnSet.removeISBN(delIsbn); 
                        isbnTree.delete(delIsbn); 
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