package Semester_3.PBO.assignment.assignment_02_play.PPBO_02_L0124092_CalistaSalsabila.controller;

import Semester_3.PBO.assignment.assignment_02_play.PPBO_02_L0124092_CalistaSalsabila.controller.BarangContorller;
import Semester_3.PBO.assignment.assignment_02_play.PPBO_02_L0124092_CalistaSalsabila.model.Barang;


public class BarangContorller {

    
    public void tambahStok(Barang barang, int jumlah){
        // tabmahi kalau misal barang nya ga ada 
        barang.setStok(barang.getStok() + jumlah);

    }

    public void pakaiBarang(Barang barang, int jumlah){
        // tabmahi error handling
        barang.setStok(barang.getStok() - jumlah);
    }

    // display detail terkait satu barang
    public void displayBarang(Barang barang){
        // try catch atau if else, kalau misal barang nya g ada
        System.out.println("Nama barang: " +barang.getName());
        System.out.println("Kategori: " +barang.getKategori());
        System.out.println("Jumlah: "+barang.getStok());
        System.out.println("Harga: "+barang.getHarga());

    }
    
}


