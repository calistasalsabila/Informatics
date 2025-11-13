class Book {
    public String title;
    public String author;
    public int year;
    public String isbn;

    public Book(String title, String author, int year, String isbn){
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }


    public void tampilkanInfo(){
        System.out.println("Book title: " + title);
        System.out.println("Book author: " + author);
        System.out.println("Book year " + year);
        System.out.println("Book isbn: " + isbn);
    }
}

class Novel extends Book{
    public String genre;
    public String rate;

    public Novel(String title, String author, int year, String isbn, String genre, String rate){
        super(title, author, year, isbn);
        this.genre = genre;
        this.rate = rate;
    }

    public void readNovel(){
        System.out.println("Read novel " + title);
    }

    public void tampilkanInfoNovel(){
        System.out.println("Novel title: " + title);
        System.out.println("Novel author: " + author);
        System.out.println("Novel year " + year);
        System.out.println("Novel isbn: " + isbn);
        System.out.println("Novel genre: " +genre);
        System.out.println("Novel rate: " +rate);
    }

}

public class PPBO_09_L0124092_CalistaSalsabila {
    public static void main(String[] args) {
        Book b1 = new Book("Atomic Habits", "James Clear", 2018, "9786020633176");
        Novel n1 =  new Novel("Omniscient Reader Viewpoint", "싱숑", 2018, "9798400903526", "fantasy, action", "4.7/5");
        Novel n2 =  new Novel("Solo Leveling", "Chugong ", 2016, "9798400903526", "fantasy, action", "4.8/5");
        Novel n3 =  new Novel("Im Not That Kind Of Talent", "Denphy", 2022, "978-0812994995", "fantasy, action", "Old Novel");

        b1.tampilkanInfo();

        n1.tampilkanInfoNovel();
        n1.readNovel();

        n2.tampilkanInfoNovel();
        n2.readNovel();

        n3.tampilkanInfoNovel();
        n3.readNovel();


    }

}