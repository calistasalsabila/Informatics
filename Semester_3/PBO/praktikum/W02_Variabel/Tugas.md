# Tugas 2: Variabel

## Ketentuan Tugas:

Anda adalah seorang pemrogram yang diberi tugas untuk membuat program sederhana untuk mengelola inventaris kantor. Kantor ini memiliki berbagai peralatan dan perlengkapan, dan pemilik kantor ingin Anda membantu melacak stok serta penggunaan barang-barang tersebut. 

1. **Array Barang**: Buat sebuah array atau ArrayList yang berisi daftar peralatan kantor. Setiap peralatan akan direpresentasikan oleh sebuah objek dengan atribut seperti nama barang (String), kategori (String misal: alat tulis, elektronik, furniture), jumlah stok (int), dan harga satuan (int).

2. **Variabel Static**: Gunakan variabel static untuk melacak jumlah total transaksi pemakaian atau pengeluaran barang yang terjadi di kantor. Variabel ini digunakan untuk melihat seberapa sering inventaris digunakan.

3. **Variabel Non-Static**: Buat variabel non-static untuk melacak total nilai inventaris (int) berdasarkan stok dan harga barang. Variabel ini akan diperbarui setiap kali ada barang baru masuk atau digunakan.

4. **Variabel Lokal**: Saat ada pegawai menggunakan barang, gunakan variabel lokal untuk menghitung jumlah barang yang dipakai dan sisa stok yang tersedia.

5. **Parameter**: Buat dua method, yaitu `pakaiBarang` dan `tambahStok`. 
- `pakaiBarang` menerima parameter berupa nama barang dan jumlah yang digunakan, kemudian mengurangi stok barang dan memperbarui total nilai inventaris. 
- `tambahStok` menerima parameter berupa nama barang dan jumlah barang yang ditambahkan, lalu menambahkan jumlah barang ke inventaris kantor.

6. **Konstanta**: Gunakan konstanta untuk mendefinisikan batas stok minimum (`MIN_STOK`) agar program dapat memberi peringatan jika stok barang terlalu sedikit.

Dengan contoh isi file sebagai berikut:

```java
// Nama : ...
// NIM  : ...

// import ...

public class PPBO_02_NIM_NamaLengkap {
    public static void main(String[] args) {
        // ...
    }
}

// class ...
```

## Pengumpulan:

Tugas dikumpulkan dalam 2 format untuk laporan dalam bentuk Portable Document File (\*.pdf) dengan ketentuan nama berkas **PPBO_02_NIM_NamaLengkap.pdf** dan untuk source kode dengan **PPBO_02_NIM_NamaLengkap.java.**

## Tenggat Waktu Pengerjaan

Tenggat waktu pengerjaan Kelas C Informatika Tugas 2 adalah hari **Selasa, 30 September 2025, pukul 23.59.**
