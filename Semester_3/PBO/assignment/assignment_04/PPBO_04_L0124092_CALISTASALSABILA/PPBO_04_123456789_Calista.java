package Semester_3.PBO.assignment.assignment_04.PPBO_04_L0124092_CALISTASALSABILA;

import java.util.*;

public class PPBO_04_123456789_Calista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Barang barang = new Barang("Unbreakable Faith", 1, 1);
        Barang barang1 = new Barang("Ways of Survival", 999999999, 3);
        Barang barang2 = new Barang("4th Wall", 1, 1);
        Barang barang3 = new Barang("Break Heavenly Demon Sword", 1, 1);


        while (true) {
            System.out.println("Welcome to ORV Store");
            System.out.println("well, u can just buy one object hehe");
            System.out.println("1. Tampilkan Barang");
            System.out.println("2. Beli n Bayar");
            System.out.println("3. Keluar");
            System.out.print("? : ");

            int opsi = sc.nextInt();
            sc.nextLine();

            switch (opsi) {
                case 1:
                    barang.tampilkanBarang();
                    break;
                case 2:
                    System.out.print("Masukkan nama barang: ");
                    String namaBarang = sc.nextLine();
                    System.out.print("jumlah: ");
                    int jumlahBeli = sc.nextInt();
                    sc.nextLine();
                    barang.beli(namaBarang, jumlahBeli, sc);
                    break;
                case 3:
                    System.out.println("ok");
                    return; 
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}
