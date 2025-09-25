package Semester_3.PBO.assignment.assignment_02_play.PPBO_02_L0124092_CalistaSalsabila.model;

public class Barang {
    private String name;
    private String kategori;
    private int stok;
    private int harga;

    Barang(String name, String kategori, int stok, int harga){
        this.name = name;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int hitungTotalHarga(){
        return stok*harga;
    }
    
}
