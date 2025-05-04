class MataKuliah {
    private String namaMatkul;
    private String kodeMatkul;
    private int sks;

    public MataKuliah(String namaMatkul, String kodeMatkul, int sks) {
        this.namaMatkul = namaMatkul;
        this.kodeMatkul = kodeMatkul;
        this.sks = sks;
    }

    // Getter and Setter
    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public void displayInfo() {
        System.out.println("Nama Mata Kuliah      : " + namaMatkul);
        System.out.println("Kode Mata Kuliah      : " + kodeMatkul);
        System.out.println("Jumlah SKS            : " + sks);
    }
}

// Inheritence
class DataStructureandAlgorithm extends MataKuliah {
    private String ProgrammingLanguage;

   
    public DataStructureandAlgorithm(String kodeMatkul, int sks, String ProgrammingLanguage) {
        super("Struktur Data dan Algoritma", kodeMatkul, sks); 
        this.ProgrammingLanguage = ProgrammingLanguage;
    }


    public String getProgrammingLanguage() {
        return ProgrammingLanguage;
    }

    public void setProgrammingLanguage(String ProgrammingLanguage) {
        this.ProgrammingLanguage = ProgrammingLanguage;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("Bahasa Pemrograman    : " + ProgrammingLanguage);
    }
}


public class Matkul {
    public static void main(String[] args) {
    
        DataStructureandAlgorithm sda = new DataStructureandAlgorithm("0953223012", 4, "Java");


        sda.displayInfo();
    }
}
