package Semester_3.PBO.assignment.assignment_04.PPBO_04_L0124092_CALISTASALSABILA.play;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Barang {

    private static ArrayList<Barang> daftarBarang = new ArrayList <> ();

    private String nama;
    private float harga;
    private int stok;

    Barang(String nama, float harga, int stok){
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        daftarBarang.add(this);

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return nama + " (Harga: " + harga + ", Stok: " + stok + ")";
    }


    public void tampilkanBarang(){
        if(!daftarBarang.isEmpty()){
            for(Barang barang : daftarBarang){
                System.out.println(barang);
            }
        }else{
            System.out.println("nothing has left~");
        }
    }

    public void cekHarganStok(String nama){
        tampilkanBarang();
        boolean found = false;
        for (Barang barang : daftarBarang) {
            if (barang.getNama().equalsIgnoreCase(nama)) {
                System.out.println("stok: " + barang.getStok());
                System.out.println("harga: " + barang.getHarga());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Barang tidak ditemukan :)))");
    }

    public void beli(String nama, int jumlah, Scanner sc){
        tampilkanBarang();
        boolean found = false;
        for (Barang barang : daftarBarang){
            if(barang.getNama().equalsIgnoreCase(nama)){ 
                barang.setStok(barang.getStok() - jumlah);

                if (barang.getStok() <= 0) {
                    daftarBarang.remove(barang);
                }

                float total = barang.getHarga() * jumlah;
                System.out.println("Total yang harus dibayarkan: " + total);
                bayar(sc, total);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Barang not found.");
    }

    public void bayar(Scanner sc, float total){
        System.out.println("masukkan jumlah uang: ");
        float uang = sc.nextFloat();
        
        if (uang < total){
            System.out.println("Uang tidak cukup");
            bayar(sc, total);
        }else if(uang == total){
            System.out.println("Thanks udah belaja disini");
        }else{
            System.out.println("kembalian anda adalah " + (uang - total) );
        }
    

    }

    public void tambahBarang(String nama, int stok, float harga){
        new Barang(nama, harga, stok);
    }


    public void tambahStok(String nama, int jumlah) {
        boolean found = false;
        for (Barang barang : daftarBarang) {
            if (barang.getNama().equalsIgnoreCase(nama)) {
                barang.setStok(barang.getStok() + jumlah);
                System.out.println("Stok untuk " + barang.getNama() + " berhasil ditambah.");
                found = true;
                break; 
            }
        }
        if (!found) {
            System.out.println("Barang dengan nama \"" + nama + "\" tidak ditemukan.");
        }
        tampilkanBarang();
    }
    
}

