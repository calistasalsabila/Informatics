package PSDA03_L0124092_CALISTASALSABILA.src.ecommerce;

public class Product {
    String kode;
    String nama;
    int stok;
    double harga;

    public Product(String kode, String nama, int stok, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void tampilkanInfo() {
        System.out.printf("Kode: %s | Nama: %s | Stok: %d | Harga: Rp%.2f%n",
                kode, nama, stok, harga);
    }
}
