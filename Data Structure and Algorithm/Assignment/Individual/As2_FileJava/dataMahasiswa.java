public class dataMahasiswa {
    private String name;
    private int nim;
    private char kelas;

    // constructor
    public dataMahasiswa(String name, int nim, char kelas) {
        this.name = name;
        this.nim = nim;
        this.kelas = kelas;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getter
    public String getName() {
        return name;
    }

    //setter
    public void setAge(int nim) {
        this.nim = nim;
    }

    public int getAge() {
        return nim;
    }

    public void setKelas(char kelas){
        this.kelas = kelas;
    }

    public int getKelas(){
        return kelas;
    }

    public void displayInfo() {
        System.out.println("Nama      : " + name);
        System.out.println("Nim       : " + nim);
        System.err.println("Kelas     : " + kelas);
    }

    public static void main(String[] args) {

        dataMahasiswa mahasiswa1 = new dataMahasiswa("Calista", 92, 'c');

        mahasiswa1.displayInfo();
    }
}
