package PSDA03_L0124092_CALISTASALSABILA.src.ecommerce;

import java.util.*;

public class ECommerceSimulasi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> produkMap = new HashMap<>();
        Map<String, CartItem> keranjang = new HashMap<>();

    
        produkMap.put("A1", new Product("A1", "Adidas Samba", 100, 1850000));
        produkMap.put("A2", new Product("A2", "Nike Air Max", 100, 2000000));
        produkMap.put("A3", new Product("A3", "New Balance", 100, 1750000));
        produkMap.put("A4", new Product("A4", "Skechers", 100, 1499000));

        
        System.out.print("Masukkan nama Anda: ");
        String namaUser = scanner.nextLine();

        double saldoAwal;
        while (true) {
            System.out.print("Masukkan saldo awal Anda: ");
            try {
                saldoAwal = Double.parseDouble(scanner.nextLine());
                if (saldoAwal < 0)
                    throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan saldo dalam angka yang valid dan tidak negatif.");
            }
        }

        User user = new User(namaUser, saldoAwal);

        int pilihan;
        do {
            System.out.println("\n=== Menu E-Commerce shoes ===");
            System.out.println("1. Lihat Produk");
            System.out.println("2. Tambah ke Keranjang");
            System.out.println("3. Lihat Keranjang");
            System.out.println("4. Hapus dari Keranjang");
            System.out.println("5. Checkout");
            System.out.println("6. Top Up Saldo");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    System.out.println("\nDaftar Produk:");
                    for (Product p : produkMap.values()) {
                        p.tampilkanInfo();
                    }
                }
                case 2 -> {

                    System.out.println("\nDaftar Produk:");
                    for (Product p : produkMap.values()) {
                        p.tampilkanInfo();
                    }

                    System.out.print("Masukkan kode produk yang ingin dibeli : ");
                    String kode = scanner.nextLine().toUpperCase();

                    if (!produkMap.containsKey(kode)) {
                        System.out.println("Produk tidak ditemukan.");
                        continue;
                    }

                    Product produk = produkMap.get(kode);
                    System.out.print("Masukkan jumlah: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine();

                    if (jumlah <= 0 || jumlah > produk.stok) {
                        System.out.println("Jumlah tidak valid atau stok tidak cukup.");
                        continue;
                    }

                    produk.kurangiStok(jumlah);

                    keranjang.compute(kode, (k, item) -> {
                        if (item == null)
                            return new CartItem(produk, jumlah);
                        item.jumlah += jumlah;
                        return item;
                    });

                    System.out.println("Produk ditambahkan ke keranjang.");
                }
                case 3 -> {
                    if (keranjang.isEmpty()) {
                        System.out.println("Keranjang kosong.");
                    } else {
                        System.out.println("\nIsi Keranjang:");
                        double total = 0;
                        for (CartItem item : keranjang.values()) {
                            item.tampilkanItem();
                            total += item.getTotalHarga();
                        }
                        System.out.printf("Total Belanja: Rp%.2f%n", total);
                        user.tampilkanInfo();
                    }
                }
                case 4 -> {
                    System.out.print("Masukkan kode produk yang ingin dihapus: ");
                    String kode = scanner.nextLine().toUpperCase();

                    if (keranjang.containsKey(kode)) {
                        CartItem item = keranjang.remove(kode);
                        item.produk.tambahStok(item.jumlah);
                        System.out.println("Produk dihapus dari keranjang.");
                    } else {
                        System.out.println("Produk tidak ada di keranjang.");
                    }
                }
                case 5 -> {
                    double total = keranjang.values().stream()
                            .mapToDouble(CartItem::getTotalHarga)
                            .sum();

                    if (keranjang.isEmpty()) {
                        System.out.println("Keranjang kosong.");
                    } else if (total > user.getSaldo()) {
                        System.out.println("Saldo tidak cukup untuk checkout.");
                    } else {
                        user.kurangiSaldo(total);
                        keranjang.clear();
                        System.out.printf("Checkout berhasil! Sisa saldo: Rp%.2f%n", user.getSaldo());
                    }
                }
                case 6 -> {
                    System.out.print("Masukkan jumlah top up: ");
                    try {
                        double topup = Double.parseDouble(scanner.nextLine());
                        if (topup <= 0) {
                            System.out.println("Jumlah harus lebih dari 0.");
                        } else {
                            user.tambahSaldo(topup);
                            System.out.printf("Top up berhasil! Saldo sekarang: Rp%.2f%n", user.getSaldo());
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Masukkan angka yang valid.");
                    }
                }
                case 0 -> System.out.println("Terima kasih telah berbelanja, " + user.getNama() + "!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
