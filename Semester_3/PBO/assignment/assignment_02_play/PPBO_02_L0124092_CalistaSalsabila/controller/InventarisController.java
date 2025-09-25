package Semester_3.PBO.assignment.assignment_02_play.PPBO_02_L0124092_CalistaSalsabila.controller;

import java.util.ArrayList;

import Semester_3.PBO.assignment.assignment_02_play.PPBO_02_L0124092_CalistaSalsabila.controller.InventarisController;
import Semester_3.PBO.assignment.assignment_02_play.PPBO_02_L0124092_CalistaSalsabila.model.Barang;
import Semester_3.PBO.assignment.assignment_02_play.PPBO_02_L0124092_CalistaSalsabila.model.Inventaris;


public class InventarisController {
    private Inventaris inventaris;

    public InventarisController(Inventaris inventaris){
        this.inventaris = inventaris;
    }

    public void tambahBarang(Barang barang){
        inventaris.getDaftarBarang().add(barang);
    }

    public void hapusBarang(int nomerBarang){
        ArrayList<Barang> daftar = inventaris.getDaftarBarang();
        if(nomerBarang > 0 && nomerBarang < daftar.size()){
            daftar.remove(nomerBarang);
        }
    }
    
    public Barang cariBarang(String nama){
        for(Barang barang : inventaris.getDaftarBarang()){
            if(barang.getName().equalsIgnoreCase(nama)){
                return barang;
            }
        }
        return null;
    }

    public ArrayList<Barang>getSemuaBarang(){
        return inventaris.getDaftarBarang();
    }

    
}
