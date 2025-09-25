package Semester_3.PBO.assignment.assignment_02.PPBO_02_L0124092_CalistaSalsabila.controller;

import model.Barang;

public class BarangContorller {
    
    public void tambahStok(Barang barang, int jumlah){
        barang.setStok(barang.setStok() + jumlah);
    }
    
}
