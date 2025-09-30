package Semester_3.PBO.assignment.assignment_02.PPBO_02_L0124092_CalistaSalsabila;

import java.util.ArrayList;


public class Inventaris {
    private static final int MIN_STOK = 2; // konstanta batas minimum stok
    private static int totalTransaksi = 0; // variabel static
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private int totalNilaiInventaris = 0; // variabel non-static

    public void tambahBarang(String nama, String kategori, int jumlah, int harga) {
        Barang barang = new Barang(nama, kategori, jumlah, harga);
        daftarBarang.add(barang);
        totalNilaiInventaris += jumlah * harga;
    }

    public void tambahStok(String nama, int jumlah) {
        for (Barang b : daftarBarang) {
            if (b.getNama().equalsIgnoreCase(nama)) {
                b.setStok(b.getStok() + jumlah);
                totalNilaiInventaris += jumlah * b.getHarga();
                System.out.println(jumlah + " " + nama + " berhasil ditambahkan.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan!");
    }

    public void pakaiBarang(String nama, int jumlah) {
        for (Barang b : daftarBarang) {
            if (b.getNama().equalsIgnoreCase(nama)) {
                int stokSebelum = b.getStok(); // variabel lokal
                if (stokSebelum >= jumlah) {
                    b.setStok(stokSebelum - jumlah);
                    totalNilaiInventaris -= jumlah * b.getHarga();
                    totalTransaksi++;

                    System.out.println(jumlah + " " + nama + " berhasil digunakan.");
                    if (b.getStok() <= MIN_STOK) {
                        System.out.println("Stok " + nama + " hampir habis! Sisa: " + b.getStok());
                    }
                } else {
                    System.out.println("Stok " + nama + " tidak mencukupi!");
                }
                return;
            }
        }
        System.out.println("Barang tidak ditemukan!");
    }

    public void tampilkanInventaris() {
        System.out.println("\nDaftar Inventaris:");
        for (Barang b : daftarBarang) {
            b.displayInfo();;
        }

        System.out.println("Total Nilai Inventaris: " + totalNilaiInventaris);
        System.out.println("Total Transaksi: " + totalTransaksi);
    }
}
