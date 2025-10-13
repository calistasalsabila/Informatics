package Semester_3.PBO.assignment.assignment_03.PPBO_03_L0124092_CALISTASALSABILA;

import java.util.ArrayList;
import java.util.Scanner;

public class PPBO_03_L0124092_CalistaSalsabila {
    ArrayList<String> buah = new ArrayList<>();
    ArrayList<String> sayur = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int opsi;

    public String checkInput(String nama){
        
        nama = nama.toLowerCase();

        if (nama.startsWith("buah")) {
            return "buah";
        } else if (nama.startsWith("sayur")) {
            return "sayur";
        } else {
            return "invalid";
        }
    }

    public void masukkanBuahAtauSayur(String nama){
        String kategori = checkInput(nama);
        
        if(kategori.equals("buah")){
            addBuah(nama);
        } else if(kategori.equals("sayur")){
            addSayur(nama);
        } else {
            System.out.println("Wajib menuliskan kategori di awal (contoh: 'buah apel' atau 'sayur bayam')");
        }
    }

    public void displayBuah(){
        System.out.println("Daftar Buah:");
        for(String b: buah){
            System.out.println("- " + b);
        }
    }

    public void displaySayur(){
        System.out.println("Daftar Sayur:");
        for(String s: sayur){
            System.out.println("- " + s);
        }
    }

    public void addBuah(String nama){
        buah.add(nama);
    }

    public void addSayur(String nama){
        sayur.add(nama);
    }

    public static void main(String[] args) {
        PPBO_03_L0124092_CalistaSalsabila app = new PPBO_03_L0124092_CalistaSalsabila();

        while (true) {
            System.out.println("1. Masukkan input");
            System.out.println("2. Lihat buah");   
            System.out.println("3. Lihat sayur");
            System.out.print("Pilih opsi: ");

            int opsi = app.scanner.nextInt();
            app.scanner.nextLine(); 

            switch (opsi) {
                case 1:
                    System.out.print("Masukkan buah atau sayur: ");
                    String nama = app.scanner.nextLine();
                    app.masukkanBuahAtauSayur(nama);
                    break;
                case 2:
                    app.displayBuah();
                    break;
                case 3:
                    app.displaySayur();
                    break;
                default:
                    System.out.println("Masukkan nomor yang valid!");
                    break;
            }
        }
    }
}
