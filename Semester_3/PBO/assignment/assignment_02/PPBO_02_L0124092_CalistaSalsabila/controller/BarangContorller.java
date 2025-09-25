package Semester_3.PBO.assignment.assignment_02.PPBO_02_L0124092_CalistaSalsabila.controller;

import model.Barang;

public class BarangContorller {

    
    public void tambahStok(Barang barang, int jumlah){
        // tabmahi kalau misal barang nya ga ada 
        barang.setStok(barang.setStok() + jumlah);

    }

    public void pakaiBarang(Barang barang, int jumlah){
        // tabmahi error handling
        barang.setStok(barang.setStok - jumlah);
    }

    // display detail terkait satu barang
    public void displayBarang(Barang barang){
        // try catch atau if else, kalau misal barang nya g ada
        System.out.println("Nama barang: " +barang);
        System.out.println("Kategori: " +barang.getKategori());
        System.out.println("Jumlah: "+getStok);
        System.out.println("Harge: "+barang.getHarga());

    }
    
}


