// Nama : Calista Salsabila
// NIM  : L0124092

import java.util.*;

// 1. Abstract Class & Interface 

abstract class MataKuliah {
    protected String nama;
    protected int sks;
    protected double nilaiFinal; 

    public MataKuliah(String nama, int sks) {
        this.nama = nama;
        this.sks = sks;
    }

    public String getNama() { return nama; }
    public int getSks() { return sks; }
    public double getNilaiFinal() { return nilaiFinal; }

    public abstract double hitungNilaiAkhir();
}

interface Penilaian {
    double getBobotNilai();
    String getGrade();
}

// 2. Concrete Classes (Mata Kuliah)

class PBO extends MataKuliah implements Penilaian {
    private double uts, uas, tugas;
    public PBO(int sks, double uts, double uas, double tugas) {
        super("PBO", sks);
        this.uts = uts; this.uas = uas; this.tugas = tugas;
    }

    public double hitungNilaiAkhir() {
        nilaiFinal = uts*0.30 + uas*0.40 + tugas*0.30;
        return nilaiFinal;
    }
    public double getBobotNilai() { return 0.4; }
    public String getGrade() {
        if (nilaiFinal >= 85) return "A";
        if (nilaiFinal >= 70) return "B";
        if (nilaiFinal >= 55) return "C";
        if (nilaiFinal >= 40) return "D";
        return "E";
    }
}

class MetNum extends MataKuliah implements Penilaian {
    private double kuis, tugas, akhir;
    public MetNum(int sks, double kuis, double tugas, double akhir) {
        super("MetNum", sks);
        this.kuis = kuis; this.tugas = tugas; this.akhir = akhir;
    }

    public double hitungNilaiAkhir() {
        nilaiFinal = kuis*0.20 + tugas*0.30 + akhir*0.50;
        return nilaiFinal;
    }
    public double getBobotNilai() { return 0.5; }
    public String getGrade() {
        if (nilaiFinal >= 90) return "A";
        if (nilaiFinal >= 75) return "B";
        if (nilaiFinal >= 60) return "C";
        if (nilaiFinal >= 45) return "D";
        return "E";
    }
}

class DAA extends MataKuliah implements Penilaian {
    private double proyek, kuis, akhir;
    public DAA(int sks, double proyek, double kuis, double akhir) {
        super("DAA", sks);
        this.proyek = proyek; this.kuis = kuis; this.akhir = akhir;
    }

    public double hitungNilaiAkhir() {
        nilaiFinal = proyek*0.40 + kuis*0.20 + akhir*0.40;
        return nilaiFinal;
    }
    public double getBobotNilai() { return 0.4; }
    public String getGrade() {
        if (nilaiFinal >= 85) return "A";
        if (nilaiFinal >= 70) return "B";
        if (nilaiFinal >= 55) return "C";
        if (nilaiFinal >= 40) return "D";
        return "E";
    }
}

class SO extends MataKuliah implements Penilaian {
    private double tugas, partisipasi, akhir;
    public SO(int sks, double tugas, double partisipasi, double akhir) {
        super("SO", sks);
        this.tugas = tugas; this.partisipasi = partisipasi; this.akhir = akhir;
    }

    public double hitungNilaiAkhir() {
        nilaiFinal = tugas*0.25 + partisipasi*0.25 + akhir*0.50;
        return nilaiFinal;
    }
    public double getBobotNilai() { return 0.5; }
    public String getGrade() {
        if (nilaiFinal >= 80) return "A";
        if (nilaiFinal >= 65) return "B";
        if (nilaiFinal >= 50) return "C";
        if (nilaiFinal >= 35) return "D";
        return "E";
    }
}

class HCI extends MataKuliah implements Penilaian {
    private double lab, tugas, akhir;
    public HCI(int sks, double lab, double tugas, double akhir) {
        super("HCI", sks);
        this.lab = lab; this.tugas = tugas; this.akhir = akhir;
    }

    public double hitungNilaiAkhir() {
        nilaiFinal = lab*0.35 + tugas*0.25 + akhir*0.40;
        return nilaiFinal;
    }
    public double getBobotNilai() { return 0.4; }
    public String getGrade() {
        if (nilaiFinal >= 88) return "A";
        if (nilaiFinal >= 73) return "B";
        if (nilaiFinal >= 58) return "C";
        if (nilaiFinal >= 43) return "D";
        return "E";
    }
}

// 3. Class Mahasiswa

class Mahasiswa {
    private String nama;
    private List<MataKuliah> daftarMk;

    public Mahasiswa(String nama) {
        this.nama = nama;
        this.daftarMk = new ArrayList<>();
    }
    public String getNama() { return nama; }
    public void addMataKuliah(MataKuliah mk) { daftarMk.add(mk); }
    
    public int totalSks() {
        int total = 0;
        for (MataKuliah mk : daftarMk) total += mk.getSks();
        return total;
    }

    public double hitungNilaiAkhirMahasiswa() {
        double sum = 0.0;
        int totalSks = totalSks();
        if (totalSks == 0) return 0.0;
        for (MataKuliah mk : daftarMk) {
            double nilaiMk = mk.hitungNilaiAkhir();
            sum += nilaiMk * mk.getSks();
        }
        return sum / totalSks;
    }

    public String getGradeFinal(double nilaiAkhir) {
        if (nilaiAkhir >= 85) return "A";
        if (nilaiAkhir >= 70) return "B";
        if (nilaiAkhir >= 55) return "C";
        if (nilaiAkhir >= 40) return "D";
        return "E";
    }

    public String mataKuliahSummary() {
        StringBuilder sb = new StringBuilder();
        for (MataKuliah mk : daftarMk) {
            sb.append(String.format("%s (SKS: %d, Nilai: %.2f) | ", mk.getNama(), mk.getSks(), mk.getNilaiFinal()));
        }
        return sb.toString();
    }
}

//  4. Class Thread

class HitungNilaiThread implements Runnable {
    private Mahasiswa mhs;
    
    public HitungNilaiThread(Mahasiswa mhs) {
        this.mhs = mhs;
    }

    public void run() {
        long start = System.nanoTime();
        
        double nilaiAkhir = mhs.hitungNilaiAkhirMahasiswa();
        
        long end = System.nanoTime();
        
        double waktuEksekusiMs = (end - start) / 1_000_000.0;
        
        String threadName = Thread.currentThread().getName();
        String grade = mhs.getGradeFinal(nilaiAkhir);
        
        System.out.printf("[%s] %s -> Total SKS: %d, Nilai Akhir: %.2f, Grade: %s (Waktu: %.4f ms)%n",
                threadName, mhs.getNama(), mhs.totalSks(), nilaiAkhir, grade, waktuEksekusiMs);
    }
}

// 5. main

public class PPBO_11_12_L0124092_CalistaSalsabila{
    
    public static void main(String[] args) {
        
        Mahasiswa m1 = new Mahasiswa("Dokja");
        Mahasiswa m2 = new Mahasiswa("Shirone");
        Mahasiswa m3 = new Mahasiswa("Cale");
        Mahasiswa m4 = new Mahasiswa("Tazk");
        Mahasiswa m5 = new Mahasiswa("L");

        // Dokja
        m1.addMataKuliah(new PBO(3, 75, 80, 70));
        m1.addMataKuliah(new MetNum(3, 70, 65, 75));
        m1.addMataKuliah(new DAA(2, 80, 70, 85));

        // Shirone
        m2.addMataKuliah(new PBO(3, 60, 58, 62));
        m2.addMataKuliah(new SO(2, 75, 80, 70));
        m2.addMataKuliah(new HCI(3, 85, 80, 90));

        // Cale
        m3.addMataKuliah(new MetNum(3, 90, 88, 92));
        m3.addMataKuliah(new DAA(3, 70, 72, 68));
        m3.addMataKuliah(new SO(2, 60, 55, 70));

        // Tazk
        m4.addMataKuliah(new PBO(3, 88, 92, 85));
        m4.addMataKuliah(new HCI(3, 70, 75, 72));
        m4.addMataKuliah(new DAA(2, 60, 65, 58));

        // L
        m5.addMataKuliah(new MetNum(3, 50, 55, 48));
        m5.addMataKuliah(new SO(2, 82, 78, 80));
        m5.addMataKuliah(new HCI(3, 66, 64, 60));

        List<Mahasiswa> daftar = Arrays.asList(m1,m2,m3,m4,m5);

        System.out.println("=========================================");
        System.out.println("       SISTEM PENILAIAN MAHASISWA        ");
        System.out.println("=========================================\n");

        // ======= Mode Single-thread =======
        System.out.println(">>> MODE SINGLE THREAD <<<");
        
        long startSingle = System.nanoTime();
        
        for (Mahasiswa m : daftar) {
            double nilaiAkhir = m.hitungNilaiAkhirMahasiswa();
            String grade = m.getGradeFinal(nilaiAkhir);
            
            System.out.println("[Single Thread]");
            System.out.println("Nama       : " + m.getNama());
            System.out.println("Matkul     : " + m.mataKuliahSummary());
            System.out.printf("Total SKS  : %d%n", m.totalSks());
            System.out.printf("Nilai Akhir: %.2f (Grade: %s)%n", nilaiAkhir, grade);
            System.out.println("-----------------------------------------");
        }
        
        long endSingle = System.nanoTime();
        double totalSingleMs = (endSingle - startSingle) / 1_000_000.0;
        
        System.out.printf("Total Waktu Single-thread: %.4f ms%n", totalSingleMs);

        // multithreading
        System.out.println("\n>>> MODE MULTITHREAD <<<");

        List<Thread> threads = new ArrayList<>();
        
        long startMulti = System.nanoTime();
        
        int idx = 1;
        for (Mahasiswa m : daftar) {
            HitungNilaiThread r = new HitungNilaiThread(m);
            Thread t = new Thread(r, "Thread-" + idx);
            threads.add(t);
            idx++;
            t.start(); 
        }

        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        
        long endMulti = System.nanoTime();
        double totalMultiMs = (endMulti - startMulti) / 1_000_000.0;
        
        System.out.printf("\nTotal Waktu Multithread: %.4f ms%n", totalMultiMs);

        // comparison n conclusio 
        System.out.println("\n=========================================");
        System.out.println("        KESIMPULAN PERBANDINGAN          ");
        System.out.println("=========================================");
        System.out.printf("Waktu Single-thread : %.4f ms%n", totalSingleMs);
        System.out.printf("Waktu Multithread   : %.4f ms%n", totalMultiMs);
        System.out.println("-----------------------------------------");

        double selisih = Math.abs(totalSingleMs - totalMultiMs);

        if (totalMultiMs < totalSingleMs) {
            System.out.printf("Hasil: MULTITHREAD lebih cepat (selisih %.4f ms).%n", selisih);
            System.out.println("Analisa: Pembagian tugas ke beberapa thread efektif mempercepat proses.");
        } else {
            System.out.printf("Hasil: SINGLE-THREAD lebih cepat (selisih %.4f ms).%n", selisih);
            System.out.println("Analisa: Karena data sedikit (5 mhs), overhead pembuatan thread");
            System.out.println("         memakan waktu lebih lama dibanding perhitungan langsung.");
        }
    }
}