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
