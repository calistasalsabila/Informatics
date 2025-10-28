package Semester_3.PBO.assignment.assignment_04.PPBO_04_L0124092_CALISTASALSABILA;


import java.util.*;

public class PPBO_04_L0124092_CalistaSalsabila {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        new Barang("Unbreakable Faith", 2.9F, 1);
        new Barang("Ways of Survival", 9.5F, 3);
        new Barang("4th Wall", 8.7F, 1);
        new Barang("Break Heavenly Demon Sword", 9.9F, 1);

        System.out.println("Welcome to Weird Store");

        while (true) {
            try {
                System.out.println("1. Tampilkan Barang");
                System.out.println("2. Beli Barang");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");
                int opsi = sc.nextInt();
                sc.nextLine();

                switch (opsi) {
                    case 1 -> Barang.tampilkanBarang();
                    case 2 ->{
                        System.out.print("Masukkan nama barang: ");
                        String namaBarang = sc.nextLine();

                        Barang barangDitemukan = null;
                        for (Barang barang : Barang.getDaftarBarang()) {
                            if (barang.getNama().equalsIgnoreCase(namaBarang)) {
                                barangDitemukan = barang;
                                break;
                            }
                        }

                        if (barangDitemukan == null) {
                            System.out.println("Barang not found!");
                            break; 
                        }

                        System.out.print("Masukkan jumlah: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("masukkan input yg valid");
                            sc.nextLine(); 
                            break;
                        }

                        int jumlahBeli = sc.nextInt();
                        sc.nextLine(); 

                        if (jumlahBeli <= 0) {
                            System.out.println("Jumlah harus > 0");
                            break;
                        }
                        Barang.beli(barangDitemukan, jumlahBeli, sc);
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
