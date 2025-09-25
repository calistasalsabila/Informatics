# Class, Object, Method, Package, dan Constructor

## Daftar Isi

[Pemrograman Berbasis Objek](#pemrograman-berbasis-objek)

[Class](#class)

[Object](#object)

[Method](#method)

[Package](#package)

[Constructor](#constructor)

## Pemrograman Berbasis Objek

Java menggunakan Pemrograman Berorientasi Objek (PBO), gaya pemrograman yang ditujukan untuk membuat pemikiran tentang pemrograman lebih mendekati pemikiran tentang dunia nyata. Di dalam PBO, setiap objek adalah unit mandiri yang memiliki identitas unik. Contohnya, sebuah apel atau cangkir merupakan objek yang berbeda meskipun tampak sama.

Objek memiliki 2 hal penting, yaitu:

- Attribute merupakan sifat atau karakteristik yang dimiliki oleh suatu objek. Contoh: Warna mobil, jumlah roda, dan isi cangkir.
- Method merupakan perilaku atau aksi yang dilakukan oleh suatu objek. Contoh: Mobil dapat berjalan, telepon dapat berdering, dan pesawat terbang dapat terbang.

## Class

Class merupakan sebuah cetakan atau rancangan untuk membuat objek. Dari satu class yang sudah terbentuk, kita dapat membuat banyak objek dengan masing-masing sifat dan perilaku yang dimilikinya. Mari kita buat sebuah Class yang disebut "Vehicle" dengan attribute dan methodnya.

```java
public class Vehicle {
  int maxSpeed;
  int wheels;
  String color;
  double fuelCapacity;

  void horn() {
    System.out.println("Beep!");
  }
}
```

maxSpeed, wheels, color, dan fuelCapacity adalah attribute-attribute dari Class Vehicle kita, dan horn() adalah satu-satunya method. Kita dapat mendefinisikan sebanyak mungkin attribute dan method yang diperlukan.

## Object

Object adalah hasil nyata dari sebuah class. Setiap objek memiliki atribut (sifat/karakteristik) dan method (perilaku) sesuai yang telah didefinisikan di class. Dalam dunia nyata, object bisa diibaratkan sebagai benda atau entitas, misalnya mobil, buku, atau manusia.

Sebagai contoh, dari class Vehicle, kita dapat membuat object yang mewakili kendaraan tersebut dengan atribut seperti warna, kecepatan, atau merk, serta method seperti "start()" atau "end()".

### Cara Membuat Object

Selanjutnya, kita dapat membuat beberapa object dari class Vehicle kita dan menggunakan sintaks titik (dot syntax) untuk mengakses attribute-attribute dan method-method mereka. Berikut adalah contoh cara membuat beberapa object Vehicle dan mengakses attribute dan method menggunakan sintaks titik:

```java
class MyClass {
  public static void main(String[ ] args) {
    Vehicle v1 = new Vehicle();  // object pertama
    Vehicle v2 = new Vehicle();  // object kedua
    v1.color = "red";            // atur atribut
    v2.horn();                   // panggil method
  }
}
```

## Method

Dalam Java, method (metode) adalah blok kode di dalam class yang digunakan untuk melakukan suatu tugas atau operasi. Method mendefinisikan perilaku dari objek, misalnya menghitung nilai, memanipulasi data, atau menampilkan hasil.

### Deklarasi dan Definisi Metode

Metode dideklarasikan dalam sebuah class dengan menentukan tipe data pengembalian (return type), nama metode, dan daftar parameter jika diperlukan.

```java
public int tambahkan(int angkaPertama, int angkaKedua) {
    // Isi metode di sini
}
```

Dalam contoh tersebut, kita mendeklarasikan metode tambahkan yang mengembalikan integer dan menerima dua parameter angkaPertama dan angkaKedua bertipe integer. Setelah deklarasi, kita mendefinisikan bagaimana metode tersebut berfungsi. Logika atau instruksi yang akan dijalankan oleh metode ditempatkan dalam blok kode metode.

```java
public int tambahkan(int angkaPertama, int angkaKedua) {
    int hasilPenjumlahan = angkaPertama + angkaKedua;
    return hasilPenjumlahan;
}
```

Dalam definisi ini, metode "tambahkan" menghitung penjumlahan dari angkaPertama dan angkaKedua, lalu mengembalikan hasilnya.

### Method Overloading

Overloading memungkinkan beberapa method memiliki nama yang sama, tetapi berbeda dalam jumlah atau tipe parameter. Return type tidak memengaruhi overloading. Saat kita memanggil metode dengan nama tersebut, Java akan memutuskan metode mana yang akan dijalankan berdasarkan jumlah dan tipe parameter yang diberikan.

Beberapa hal yang perlu diingat tentang method overloading:

- Nama yang Sama: Metode-metode dalam method overloading harus memiliki nama yang sama.
- Parameter yang Berbeda: Setiap metode dalam overloading harus memiliki daftar parameter yang berbeda. Ini bisa berbeda dalam jumlah parameter, tipe parameter, atau keduanya.
- Tipe Parameter: Tipe parameter yang berbeda dapat mencakup perbedaan dalam urutan tipe data, jumlah tipe data, atau keduanya.
- Tidak Bergantung pada Return Type: Compiler hanya mempertimbangkan parameter saat memutuskan metode mana yang harus dijalankan. Tipe balik (return type) tidak mempengaruhi pemilihan metode.

```java
public class Kalkulator {
    // Metode untuk menjumlahkan dua bilangan bulat
    public int tambah(int a, int b) {
        return a + b;
    }

    // Metode untuk menjumlahkan tiga bilangan bulat
    public int tambah(int a, int b, int c) {
        return a + b + c;
    }

    // Metode untuk menjumlahkan dua bilangan desimal
    public double tambah(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Kalkulator kalkulator = new Kalkulator();

        System.out.println("Hasil 1: " + kalkulator.tambah(5, 10)); // 15
        System.out.println("Hasil 2: " + kalkulator.tambah(5, 10, 15)); // 30
        System.out.println("Hasil 3: " + kalkulator.tambah(2.5, 3.5)); // 6.0
    }
}
```

Dalam contoh di atas, kelas Kalkulator memiliki tiga metode tambah yang merupakan contoh dari method overloading. Ketiga metode tersebut memiliki nama yang sama (tambah) tetapi berbeda dalam hal jumlah dan tipe parameter. Compiler akan memutuskan metode mana yang harus dijalankan berdasarkan parameter yang diberikan saat memanggilnya.

### Pemanggilan Metode

Setelah definisi metode, kita dapat memanggilnya dari bagian lain dalam program atau dari objek yang sesuai.

```java
Matematika objek = new Matematika();
int hasilPenjumlahan = objek.tambahkan(5, 3);
```

Dalam contoh ini, kita membuat objek dari class Matematika dan kemudian memanggil metode tambahkan pada objek tersebut dengan memberikan argumen 5 dan 3. Hasil penjumlahan akan disimpan dalam variabel hasilPenjumlahan.

Metode dapat memiliki berbagai jenis tipe data pengembalian (atau tidak memiliki pengembalian dengan tipe data void) dan parameter-parameter yang berbeda sesuai dengan kebutuhan program. Metode digunakan untuk memisahkan dan mengorganisasi kode agar lebih mudah dimengerti dan dikelola.

## Package

Package adalah cara untuk mengelompokkan class dan interface dalam Java agar kode lebih teratur, tujuannya untuk menghindari konflik nama, dan mudah untuk digunakan kembali.

### Struktur Package

Package berupa direktori/folder yang berisi file-file Java. Biasanya diberi nama domain terbalik, misalnya “com.example.app” untuk mencegah tabrakan nama.

### Import Package

Untuk menggunakan class dari package lain, kita perlu mengimpornya menggunakan keyword import. Hal ini memungkinkan kita menggunakan class-class dari package lain tanpa harus menuliskan nama lengkapnya setiap saat. Gunakan wildcard untuk mengimpor semua kelas dalam sebuah paket.
Misalnya, `import sampel.*` akan mengimpor semua kelas dalam paket `sampel`.

### Contoh Penggunaan

```java
// Import class ArrayList dari package java.util
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Membuat objek ArrayList dari package java.util
        ArrayList<String> daftarNama = new ArrayList<>();
        daftarNama.add("Alice");
        daftarNama.add("Bob");
        System.out.println(daftarNama);
    }
}
```

Dalam contoh di atas, kita mengimpor kelas ArrayList dari package java.util agar dapat menggunakannya dalam kode kita.

Penggunaan package membantu menjaga kode program yang lebih besar tetap teratur dan mudah dikelola. Hal ini juga memungkinkan kita untuk membagikan kode dengan orang lain dalam bentuk yang lebih terstruktur dan modular.

## Constructor

Constructor adalah metode khusus dalam sebuah kelas yang digunakan untuk menginisialisasi objek. Ciri utamanya:

- Namanya sama dengan nama kelas.
- Tidak memiliki return type (bahkan void).
- Dipanggil otomatis saat objek dibuat.

```java
public class Karyawan {
    // Variabel-variabel anggota kelas
    String nama;
    int usia;

    // Constructor tanpa parameter
    public Karyawan() {
        nama = "Belum Diketahui";
        usia = 0;
    }

    // Constructor dengan parameter
    public Karyawan(String nama, int usia) {
        this.nama = nama;
        this.usia = usia;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Usia: " + usia + " tahun");
    }

    public static void main(String[] args) {
        // Membuat objek Karyawan dengan constructor tanpa parameter
        Karyawan karyawan1 = new Karyawan();

        // Membuat objek Karyawan dengan constructor dengan parameter
        Karyawan karyawan2 = new Karyawan("Alice", 30);

        // Memanggil metode untuk menampilkan informasi karyawan
        karyawan1.tampilkanInfo();
        karyawan2.tampilkanInfo();
    }
}
```

Dalam contoh di atas, kita memiliki dua constructor: satu tanpa parameter dan satu dengan parameter. Kedua constructor digunakan untuk menginisialisasi objek Karyawan dengan nilai awal yang sesuai.
