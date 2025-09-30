package Semester_3.PBO.assignment.assignment_02.PPBO_02_L0124092_CalistaSalsabila;

public class Barang {
    private String nama;
    private String kategori;
    private int stok;
    private int harga;

    Barang(String nama, String kategori, int stok, int harga){
        this.nama = nama;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

   public void displayInfo(){
    System.out.println("Nama barang: " +getNama());
        System.out.println("Kategori: " +getKategori());
        System.out.println("Jumlah: "+getStok());
        System.out.println("Harga: "+getHarga());
   } 
   
    
}
