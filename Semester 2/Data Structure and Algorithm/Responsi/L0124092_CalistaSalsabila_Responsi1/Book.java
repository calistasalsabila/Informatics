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
        return String.format("Judul: %s | ISBN: %s | Genre: %s", title, isbn, genre);
    }
}
