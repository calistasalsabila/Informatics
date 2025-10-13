package Semester_3.PBO.assignment.assignment_04.PPBO_04_L0124092_CALISTASALSABILA;

import java.util.ArrayList;
public class Barang {

    private static ArrayList<Barang> daftarBarang = new ArrayList <> ();
    
    private String nama;
    private int harga;
    private int stok;

    Barang(String nama, int harga, int stok){
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

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
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
        if(daftarBarang.size() != 0){
            for(Barang barang : daftarBarang){
                System.out.println(barang);
            }
        }else{
            System.out.println("nothing has left~");
        }
    }

    public void cekHarganStok(String nama){
        tampilkanBarang();
        for (Barang barang : daftarBarang){
            if(barang.getNama().equalsIgnoreCase(nama)){
                System.out.println("stok: " + barang.getStok());
                System.out.println("harga: " + barang.getHarga());
                return;
            }else{
                System.out.println("sesuai list la :)))");
            }
        }
    }

    public void beli(String nama, int jumlah){
        tampilkanBarang();
        for (Barang barang : daftarBarang){
            if(barang.getNama().equalsIgnoreCase(nama)){
                barang.setStok(barang.getStok() - jumlah);
                if (barang.getStok() <= 0) daftarBarang.remove(barang);
                int total = barang.getHarga() * getStok();
                System.out.println("total yang harus di bayarkan? " + total);
                bayar();
            }else{
                System.out.println("not found");
            }
        }
    }

    public void bayar(){
        System.out.println("masukkan jumlah uang: ");
        // input
        // var 
        System.out.println("kembalian anda adalah " ); // kembaliannya berapa

    }

    public void tambahBarang(String nama, int stok, int harga){
        Barang barang = new Barang(nama, harga, stok);
        daftarBarang.add(barang);
    }

     public void tambahStok(Barang barang, int jumlah){
        // cek dl ada g
        barang.setStok(barang.getStok() + jumlah);

    }





    
}
