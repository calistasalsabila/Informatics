// Nama : Calista Salsabila
// NIM  : L0124092

abstract class Karyawan {
    protected String nama;

    public Karyawan(String nama) {
        this.nama = nama;
    }

    // Runtime polymorphism → wajib override
    public abstract double hitungGaji();

    // overloading
    public void inputData() {}
    public void inputData(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
}

class KaryawanGajiTetap extends Karyawan {
    private double gajiMingguan;

    public KaryawanGajiTetap(String nama, double gajiMingguan) {
        super(nama);
        this.gajiMingguan = gajiMingguan;
    }

    @Override
    public double hitungGaji() {
        return gajiMingguan;
    }
}

class KaryawanPerJam extends Karyawan {
    private double upahPerJam;
    private int jamKerja;

    public KaryawanPerJam(String nama, double upahPerJam, int jamKerja) {
        super(nama);
        this.upahPerJam = upahPerJam;
        this.jamKerja = jamKerja;
    }

    @Override
    public double hitungGaji() {
        return upahPerJam * jamKerja;
    }
}

class KaryawanKomisi extends Karyawan {
    protected double gajiPokok;
    protected double totalPenjualan;
    protected double persentaseKomisi;

    public KaryawanKomisi(String nama, double gajiPokok, double totalPenjualan, double persentaseKomisi) {
        super(nama);
        this.gajiPokok = gajiPokok;
        this.totalPenjualan = totalPenjualan;
        this.persentaseKomisi = persentaseKomisi;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + (totalPenjualan * persentaseKomisi);
    }
}

class KaryawanKomisiPlus extends KaryawanKomisi {

    public KaryawanKomisiPlus(String nama, double gajiPokok, double totalPenjualan, double persentaseKomisi) {
        super(nama, gajiPokok, totalPenjualan, persentaseKomisi);
    }

    @Override
    public double hitungGaji() {
        double gajiNormal = super.hitungGaji();
        double bonus = 0.10 * gajiPokok; 
        return gajiNormal + bonus;
    }
}

public class PPBO_10_L0124092_CalistaSalsabila {
    public static void main(String[] args) {

        Karyawan[] data = new Karyawan[4];

        data[0] = new KaryawanGajiTetap("Ali", 1000000);
        data[1] = new KaryawanPerJam("Raib", 50000, 40);
        data[2] = new KaryawanKomisi("Seli", 800000, 5000000, 0.1);
        data[3] = new KaryawanKomisiPlus("Tazk", 800000, 5000000, 0.1);

        System.out.println("=== Daftar Gaji Mingguan ===");
        for (Karyawan k : data) {
            System.out.println(k.getNama() + " : " + k.hitungGaji());
        }

        /*
         * i. Bagaimana polimorfisme dapat membantu perusahaan?
         *    - Perusahaan bisa menghitung gaji berbagai tipe karyawan melewati satu interface yang sama.
         *      Tidak perlu  menggunakan if-else panjang. Penambahan tipe karyawan baru juga akan menjadi jauh lebih mudah.
         *
         * ii. Apakah program dapat bekerja tanpa polimorfisme?
         *    - Bisa, tapi akan berantakan : penuh if-else, tidak scalable, sulit diperluas serta rawan bug.
         *      Polimorfisme membantu mengurangi duplikasi dan meningkatkan fleksibilitas program.
         */
    }
}

