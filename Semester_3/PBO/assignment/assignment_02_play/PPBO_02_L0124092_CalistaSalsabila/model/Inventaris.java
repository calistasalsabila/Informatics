package Semester_3.PBO.assignment.assignment_02_play.PPBO_02_L0124092_CalistaSalsabila.model;

import java.util.ArrayList;

public class Inventaris {

    private ArrayList<Barang> daftarBarang;

    public Inventaris(){
        daftarBarang = new ArrayList<>();
    }

    public ArrayList<Barang> getDaftarBarang() {
        return daftarBarang;
    }

    public void setDaftarBarang(ArrayList<Barang> daftarBarang) {
        this.daftarBarang = daftarBarang;
    }
    
}
