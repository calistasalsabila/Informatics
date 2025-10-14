package Semester_3.PBO.assignment.assignment_04.PPBO_04_L0124092_CALISTASALSABILA;

import java.util.*;

public class PPBO_04_L0124092_CalistaSalsabila {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        new Barang("Unbreakable Faith", 1, 1);
        new Barang("Ways of Survival", 1, 3);
        new Barang("4th Wall", 1, 1);
        new Barang("Break Heavenly Demon Sword", 1, 1);

        System.out.println("Welcome to ORV Store");

        while (true) {
            try {
                System.out.println("\n1. Tampilkan Barang");
                System.out.println("2. Beli Barang");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");
                int opsi = sc.nextInt();
                sc.nextLine();

                switch (opsi) {
                    case 1 -> Barang.tampilkanBarang();
                    case 2 -> {
                        System.out.print("Masukkan nama barang: ");
                        String nama = sc.nextLine();

                        System.out.print("Masukkan jumlah: ");
                        int jumlah = sc.nextInt();
                        sc.nextLine();

                        assert jumlah > 0 : "jumlah harus lebih dari 0";

                        Barang.beli(nama, jumlah, sc);
                    }
                    case 3 -> {
                        System.out.println("Thanks!");
                        return;
                    }
                    default -> System.out.println("invalid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("masukkan input yg sesuai");
                sc.nextLine(); 
            } catch (AssertionError ae) {
                System.out.println("salah input: " + ae.getMessage());
            } catch (Exception e) {
                System.out.println("error " + e.getMessage());
            }
        }
    }
}
