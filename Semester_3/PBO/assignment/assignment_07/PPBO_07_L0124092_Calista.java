// Nama : Calista
// NIM  : L0124092

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class Agenda {
    private String waktu;
    private String deskripsi;
    private String namaKegiatan;

    public Agenda(String waktu, String deskripsi, String namaKegiatan) {
        this.waktu = waktu;
        this.deskripsi = deskripsi;
        this.namaKegiatan = namaKegiatan;
    }

    // Getter dan Setter
    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public String toString() {
        return String.format("Waktu: %s | Kegiatan: %s | Deskripsi: %s", waktu, namaKegiatan, deskripsi);
    }
}

public class PPBO_07_L0124092_Calista {
    private static final String DATE_FORMAT = "dd-MM-yyyy";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Agenda> daftarAgenda = new ArrayList<>();

        String tanggalHariIni = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        String namaFile = tanggalHariIni + ".txt";

    
        bacaDariFile(daftarAgenda, namaFile);

        System.out.println("-PROGRAM AGENDA HARIAN-");
        System.out.print("Berapa banyak agenda yang ingin ditambahkan?: ");
        int jumlah = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nAgenda ke-" + (i + 1));
            System.out.print("Masukkan waktu (contoh 08:00): ");
            String waktu = input.nextLine();
            System.out.print("Masukkan nama kegiatan: ");
            String nama = input.nextLine();
            System.out.print("Masukkan deskripsi kegiatan: ");
            String deskripsi = input.nextLine();

            daftarAgenda.add(new Agenda(waktu, deskripsi, nama));
        }

        System.out.println("\n-Daftar Agenda Hari Ini-");
        for (Agenda a : daftarAgenda) {
            System.out.println(a);
        }

        simpanKeFile(daftarAgenda, namaFile);
        System.out.println("\nData agenda berhasil disimpan ke file: " + namaFile);

        input.close();
    }

    private static void simpanKeFile(List<Agenda> daftarAgenda, String namaFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            for (Agenda a : daftarAgenda) {
                writer.write(a.getWaktu() + ";" + a.getNamaKegiatan() + ";" + a.getDeskripsi());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan file: " + e.getMessage());
        }
    }

    private static void bacaDariFile(List<Agenda> daftarAgenda, String namaFile) {
        File file = new File(namaFile);
        if (!file.exists()) {
            System.out.println("Belum ada file agenda untuk tanggal hari ini.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {                                                                  
            String baris;
            while ((baris = reader.readLine()) != null) {
                String[] data = baris.split(";");
                if (data.length == 3) {
                    daftarAgenda.add(new Agenda(data[0], data[2], data[1]));
                }
            }
            System.out.println("Data dari file " + namaFile + " berhasil dibaca kembali.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
    }
}
