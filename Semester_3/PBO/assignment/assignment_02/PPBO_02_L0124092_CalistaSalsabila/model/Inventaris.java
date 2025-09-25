package Semester_3.PBO.assignment.assignment_02.PPBO_02_L0124092_CalistaSalsabila.model;

import java.util.ArrayList;
public class Inventaris {

    private ArrayLIst<Barang> daftarBarang;

    public Inventaris(){
        daftarBarang = new ArrayList<>();
    }

    public ArrayLIst<Barang> getDaftarBarang() {
        return daftarBarang;
    }

    public void setDaftarBarang(ArrayLIst<Barang> daftarBarang) {
        this.daftarBarang = daftarBarang;
    }
    
}
