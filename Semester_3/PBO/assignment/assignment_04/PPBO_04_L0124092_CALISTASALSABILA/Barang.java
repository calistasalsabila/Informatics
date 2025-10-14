package Semester_3.PBO.assignment.assignment_04.PPBO_04_L0124092_CALISTASALSABILA;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Barang {
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();

    private String nama;
    private float harga;
    private int stok;

    public Barang(String nama, float harga, int stok) {
        assert harga >= 0 : " tdk boleh negatif";
        assert stok >= 0 : " tdk boleh negatif";
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        daftarBarang.add(this);
    }

    public String getNama() { 
        return nama; 
    }

    public float getHarga() { 
        return harga; 
    }

    public int getStok() {
         return stok; 
    }

    public void setStok(int stok) { 
        this.stok = stok; 
    }
    
    public static ArrayList<Barang> getDaftarBarang() {
        return daftarBarang;
    }


    @Override
    public String toString() {
        return nama + " (Harga: " + harga + ", Stok: " + stok + ")";
    }

    public static void tampilkanBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println("\nDaftar Barang:");
            for (Barang barang : daftarBarang) {
                System.out.println("- " + barang);
            }
        }
    }

    public static void beli(String nama, int jumlah, Scanner sc) throws Exception {
        boolean found = false;

        for (Barang barang : daftarBarang) {
            if (barang.getNama().equalsIgnoreCase(nama)) {
                found = true;

                if (barang.getStok() == 0)
                    throw new Exception("Barang " + nama + " sudah habis!");

                if (barang.getStok() < jumlah)
                    throw new Exception("Stok tidak cukup untuk " + nama);

                barang.setStok(barang.getStok() - jumlah);
                float total = barang.getHarga() * jumlah;
                System.out.println("Total harga: " + total);
                bayar(sc, total);
                break;
            }
        }

        if (!found) throw new Exception("Barang not found");
    }

    public static void bayar(Scanner sc, float total) {
        try {
            System.out.print("Masukkan uang: ");
            float uang = sc.nextFloat();

            assert uang >= 0 : "Uang tdk boleh negatif";

            if (uang < total)
                throw new IllegalArgumentException("Uang tidak cukup..");

            float kembalian = uang - total;
            System.out.println("success, Kembalian: " + kembalian);
        } catch (InputMismatchException e) {
            System.out.println("input uang wajib angka");
            sc.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(" " + e.getMessage());
        } catch (AssertionError ae) {
            System.out.println("error " + ae.getMessage());
        }
    }
}
