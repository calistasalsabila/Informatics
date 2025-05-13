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

    // Mengecek apakah ISBN sudah ada
    public boolean contains(String isbn) {
        boolean result = isbnSet.contains(isbn);
        System.out.println(result ? "ISBN ditemukan dalam set." : "ISBN tidak ditemukan dalam set.");
        return result;
    }

    // Menghapus ISBN dari set
    public void removeISBN(String isbn) {
        if (isbnSet.remove(isbn)) {
            System.out.println("ISBN \"" + isbn + "\" dihapus dari set.");
        } else {
            System.out.println("ISBN \"" + isbn + "\" tidak ditemukan di set.");
        }
    }    

    // Menampilkan semua ISBN yang tersimpan
    public void displayAllISBN() {
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
