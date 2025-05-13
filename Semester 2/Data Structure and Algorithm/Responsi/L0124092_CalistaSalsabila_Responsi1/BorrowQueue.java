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
