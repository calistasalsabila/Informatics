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
