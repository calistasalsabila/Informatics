// Nama : Calista
// NIM  : 123456789

package Semester_3.PBO.assignment.assignment_04.PPBO_04_L0124092_CALISTASALSABILA;

import java.util.*;

class Barang {
    String nama;
    double harga;
    int stok;

    Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    void kurangiStok(int jumlah) throws Exception {
        if (jumlah > stok) {
            throw new Exception("tok tidak cukup untuk " + nama);
        }
        stok -= jumlah;
    }

    @Override
    public String toString() {
        return nama + " - Rp" + harga + " (Stok: " + stok + ")";
    }
}

public class PBPO_04_123456789_Calista {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Barang> daftarBarang = new ArrayList<>();
        daftarBarang.add(new Barang("Pensil", 2000, 10));
        daftarBarang.add(new Barang("Buku", 5000, 5));
        daftarBarang.add(new Barang("Penghapus", 1500, 8));

        System.out.println("Daftar Barang:");

        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println((i + 1) + ". " + daftarBarang.get(i));
        }

        try {
            System.out.print("\nMasukkan nomor barang yang ingin dibeli: ");
            int pilihan = input.nextInt();

            assert (pilihan > 0 && pilihan <= daftarBarang.size()) : "Pilihan tidak valid!";

            Barang barangDipilih = daftarBarang.get(pilihan - 1);
            System.out.print("Masukkan jumlah yang ingin dibeli: ");
            int jumlah = input.nextInt();

            assert (jumlah > 0) : "Jumlah pembelian harus lebih dari 0!";

            barangDipilih.kurangiStok(jumlah);
            double total = jumlah * barangDipilih.harga;

            System.out.println("\nembelian berhasil!");
            System.out.println("Barang: " + barangDipilih.nama);
            System.out.println("Jumlah: " + jumlah);
            System.out.println("Total Bayar: Rp" + total);

        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        } catch (InputMismatchException ime) {
            System.out.println("Input harus berupa angka!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            System.out.println("Ty");
        }

        input.close();
    }
}

