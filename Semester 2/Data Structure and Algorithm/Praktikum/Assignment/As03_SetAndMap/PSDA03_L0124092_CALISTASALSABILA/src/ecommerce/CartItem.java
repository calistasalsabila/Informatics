package PSDA03_L0124092_CALISTASALSABILA.src.ecommerce;

public class CartItem {
    Product produk;
    int jumlah;

    public CartItem(Product produk, int jumlah) {
        this.produk = produk;
        this.jumlah = jumlah;
    }

    public double getTotalHarga() {
        return produk.harga * jumlah;
    }

    public void tampilkanItem() {
        System.out.printf("%s x%d (Rp%.2f)%n",
                produk.nama, jumlah, getTotalHarga());
    }
}
