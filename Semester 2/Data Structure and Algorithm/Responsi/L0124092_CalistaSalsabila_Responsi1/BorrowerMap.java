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
