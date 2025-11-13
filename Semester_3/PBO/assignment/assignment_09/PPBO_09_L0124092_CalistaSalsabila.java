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

    public void cekUsiaBuku(){
        if(year < 2020){
            System.out.println(title +" is an old book");
        }else{
            System.out.println(title + " is a new Book");
        }
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
        System.out.println("\n");
        }

    @Override
    public void tampilkanInfo(){
        super.tampilkanInfo();
        System.out.println("Novel genre: " +genre);
        System.out.println("Novel rate: " +rate);
    }

}

public class PPBO_09_L0124092_CalistaSalsabila {
    public static void main(String[] args) {
        Book b1 = new Book("Atomic Habits", "James Clear", 2018, "9786020633176");
        Novel n1 =  new Novel("Omniscient Reader Viewpoint", "싱숑", 2018, "9798400903526", "fantasy, action", "4.7/5");
        Novel n2 =  new Novel("Solo Leveling", "Chugong ", 2016, "9798400903526", "fantasy, action", "4.8/5");
        Novel n3 =  new Novel("Im Not That Kind Of Talent", "Denphy", 2022, "9780812994995", "fantasy, action", "Old Novel");

        n1.tampilkanInfo();
        n1.readNovel();

        n2.tampilkanInfo();
        n2.readNovel();

        n3.tampilkanInfo();
        n3.readNovel();

        b1.tampilkanInfo();


        b1.cekUsiaBuku();
        n1.cekUsiaBuku();
        n2.cekUsiaBuku();
        n3.cekUsiaBuku();

    }

}