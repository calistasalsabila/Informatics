package PSDA03_L0124092_CALISTASALSABILA.src.ecommerce;

public class User {
    private String nama;
    private double saldo;

    public User(String nama, double saldoAwal) {
        this.nama = nama;
        this.saldo = saldoAwal;
    }

    public String getNama() {
        return nama;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean kurangiSaldo(double jumlah) {
        if (jumlah > saldo)
            return false;
        saldo -= jumlah;
        return true;
    }

    public void tambahSaldo(double jumlah) {
        saldo += jumlah;
    }

      public void tampilkanInfo() {
        System.out.printf("%s | Saldo: Rp%.2f%n", nama, saldo);
    }
}
