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
