package Semester_3.PBO.assignment.assignment_02_play.mvc.model;

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
