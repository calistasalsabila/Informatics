## Rangkuman

---

### **BAB 1: Pengantar Object-Oriented Programming (OOP)**

#### **1.1 Apa itu OOP?**

Object-Oriented Programming (OOP) adalah paradigma pemrograman yang berfokus pada objek, yaitu entitas yang merepresentasikan data (atribut) dan perilaku (metode). Tujuan utama OOP adalah membuat kode yang modular, mudah dipelihara, reusable, dan menyerupai cara berpikir manusia terhadap dunia nyata.

Contoh analogi:

> Mobil memiliki atribut (warna, merek, kecepatan) dan perilaku (maju, berhenti). Dalam OOP, atribut direpresentasikan sebagai variabel, sedangkan perilaku direpresentasikan sebagai metode.

#### **1.2 Empat Pilar Utama OOP**

1. **Encapsulation (Enkapsulasi)** → Membungkus data dan metode agar terlindungi dari akses langsung.
2. **Inheritance (Pewarisan)** → Memungkinkan kelas baru (subclass) mewarisi atribut dan metode dari kelas lain (superclass).
3. **Polymorphism (Polimorfisme)** → Satu metode yang sama dapat memiliki perilaku berbeda pada objek yang berbeda.
4. **Abstraction (Abstraksi)** → Menyembunyikan detail implementasi dan hanya menampilkan fitur penting kepada pengguna.

#### **1.3 Pemrograman Prosedural vs. OOP**

| Paradigma  | Fokus Utama                     | Contoh            | Ciri                              |
| ---------- | ------------------------------- | ----------------- | --------------------------------- |
| Prosedural | Fungsi dan langkah              | C, Pascal         | Data dan fungsi terpisah          |
| OOP        | Objek dan interaksi antar objek | Java, Python, C++ | Data dan fungsi dibungkus bersama |

#### **1.4 Proses Kompilasi Java**

1. Menulis kode dalam file `.java`.
2. Mengompilasi dengan `javac`, menghasilkan file `.class` (bytecode).
3. Bytecode dijalankan oleh JVM (Java Virtual Machine) di berbagai platform.

```
Source (.java) → javac → Bytecode (.class) → JVM → Eksekusi di mesin
```

#### **1.5 Konsep WORA (Write Once, Run Anywhere)**

Kode Java cukup ditulis sekali dan bisa dijalankan di berbagai sistem operasi selama memiliki JVM.

---

### **BAB 2: Class dan Object**

#### **2.1 Class**

Class adalah blueprint atau cetak biru dari objek. Class mendefinisikan atribut (variabel) dan metode (fungsi) yang akan dimiliki oleh objek.

```java
class Mahasiswa {
    String nama;
    int umur;

    void belajar() {
        System.out.println(nama + " sedang belajar.");
    }
}
```

#### **2.2 Object**

Objek adalah instansi nyata dari class.

```java
public class Main {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa();
        m1.nama = "Calista";
        m1.umur = 19;
        m1.belajar();
    }
}
```

**Output:**

```
Calista sedang belajar.
```

#### **2.3 Keyword `new`**

Digunakan untuk membuat objek baru di memori heap.

---

### **BAB 3: Constructor dan Alokasi Memori**

#### **3.1 Constructor**

Constructor adalah metode khusus yang otomatis dipanggil saat objek dibuat.

```java
class Buku {
    String judul;
    int tahunTerbit;

    Buku(String judul, int tahunTerbit) {
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    void info() {
        System.out.println(judul + " (" + tahunTerbit + ")");
    }
}

public class Main {
    public static void main(String[] args) {
        Buku b1 = new Buku("Pemrograman Java", 2024);
        b1.info();
    }
}
```

**Output:**

```
Pemrograman Java (2024)
```

#### **3.2 Jenis Constructor**

* **Default Constructor:** dibuat otomatis jika tidak ada constructor lain.
* **Parameterized Constructor:** menerima parameter untuk menginisialisasi atribut.

#### **3.3 Heap dan Stack Memory**

| Jenis | Fungsi                                 | Contoh       |
| ----- | -------------------------------------- | ------------ |
| Heap  | Menyimpan objek                        | `new Buku()` |
| Stack | Menyimpan referensi dan variabel lokal | `Buku b1`    |

---

### **BAB 4: Inheritance (Pewarisan)**

#### **4.1 Konsep**

Inheritance memungkinkan kelas turunan menggunakan atribut dan metode dari kelas induk.

```java
class Hewan {
    void makan() {
        System.out.println("Hewan sedang makan");
    }
}

class Kucing extends Hewan {
    void suara() {
        System.out.println("Meong");
    }
}

public class Main {
    public static void main(String[] args) {
        Kucing k = new Kucing();
        k.makan();
        k.suara();
    }
}
```

**Output:**

```
Hewan sedang makan
Meong
```

#### **4.2 Keyword `super`**

* `super()` digunakan untuk memanggil constructor dari superclass.
* `super.methodName()` memanggil metode induk yang di-override.

#### **4.3 Jenis Inheritance**

1. **Single:** satu superclass, satu subclass.
2. **Multilevel:** pewarisan bertingkat.
3. **Hierarchical:** beberapa subclass dari satu superclass.
4. **Multiple:** hanya melalui interface (bukan class).

---

### **BAB 5: Encapsulation (Enkapsulasi)**

#### **5.1 Konsep Dasar**

Enkapsulasi digunakan untuk menyembunyikan data agar tidak diakses secara langsung.

```java
class AkunBank {
    private double saldo;

    public void setSaldo(double saldo) {
        if (saldo > 0) this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Main {
    public static void main(String[] args) {
        AkunBank akun = new AkunBank();
        akun.setSaldo(1000000);
        System.out.println("Saldo: " + akun.getSaldo());
    }
}
```

**Output:**

```
Saldo: 1000000.0
```

#### **5.2 Access Modifiers**

| Modifier  | Akses                         | Keterangan                 |
| --------- | ----------------------------- | -------------------------- |
| public    | Semua tempat                  | Bisa diakses dari mana pun |
| protected | Package + subclass            | Digunakan untuk pewarisan  |
| default   | Hanya dalam package           | Tidak pakai modifier       |
| private   | Hanya dalam class itu sendiri | Data tersembunyi           |

---

### **BAB 6: Polymorphism (Polimorfisme)**

#### **6.1 Overloading (Compile-Time Polymorphism)**

Metode dengan nama sama, parameter berbeda.

```java
class Kalkulator {
    int tambah(int a, int b) { return a + b; }
    double tambah(double a, double b) { return a + b; }
}

public class Main {
    public static void main(String[] args) {
        Kalkulator k = new Kalkulator();
        System.out.println(k.tambah(2, 3));
        System.out.println(k.tambah(1.5, 2.3));
    }
}
```

**Output:**

```
5
3.8
```

#### **6.2 Overriding (Run-Time Polymorphism)**

```java
class Hewan {
    void suara() { System.out.println("Hewan bersuara"); }
}

class Anjing extends Hewan {
    void suara() { System.out.println("Guk guk"); }
}

public class Main {
    public static void main(String[] args) {
        Hewan h = new Anjing(); // Upcasting
        h.suara();
    }
}
```

**Output:**

```
Guk guk
```

---

### **BAB 7: Abstraction (Abstraksi)**

#### **7.1 Abstract Class**

```java
abstract class Hewan {
    abstract void suara();
    void tidur() { System.out.println("Hewan tidur"); }
}

class Kucing extends Hewan {
    void suara() { System.out.println("Meong"); }
}

public class Main {
    public static void main(String[] args) {
        Hewan k = new Kucing();
        k.suara();
        k.tidur();
    }
}
```

**Output:**

```
Meong
Hewan tidur
```

#### **7.2 Interface**

Interface digunakan untuk mendefinisikan kontrak perilaku yang wajib diimplementasikan oleh class.

```java
interface Kendaraan {
    void berjalan();
}

class Mobil implements Kendaraan {
    public void berjalan() {
        System.out.println("Mobil melaju di jalan");
    }
}

public class Main {
    public static void main(String[] args) {
        Kendaraan k = new Mobil();
        k.berjalan();
    }
}
```

**Output:**

```
Mobil melaju di jalan
```

---

### **BAB 8: Class dan Object Lanjutan**

#### **8.1 Static Keyword**

* **Static variable** → milik class, bukan objek.
* **Static method** → dapat dipanggil tanpa membuat objek.

```java
class Matematika {
    static double PI = 3.14159;

    static int kuadrat(int x) {
        return x * x;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Matematika.PI);
        System.out.println(Matematika.kuadrat(5));
    }
}
```

**Output:**

```
3.14159
25
```

---

### **BAB 9: Inner Class & Anonymous Class**

#### **9.1 Inner Class**

Class di dalam class lain.

```java
class Luar {
    void tampil() {
        System.out.println("Ini class luar");
    }

    class Dalam {
        void tampilDalam() {
            System.out.println("Ini class dalam");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Luar.Dalam obj = new Luar().new Dalam();
        obj.tampilDalam();
    }
}
```

**Output:**

```
Ini class dalam
```

#### **9.2 Anonymous Class**

Class tanpa nama yang didefinisikan langsung saat pembuatan objek.

```java
abstract class Hewan {
    abstract void suara();
}

public class Main {
    public static void main(String[] args) {
        Hewan h = new Hewan() {
            void suara() {
                System.out.println("Suara anonim");
            }
        };
        h.suara();
    }
}
```

**Output:**

```
Suara anonim
```

---

### **Kesimpulan Akhir**

1. OOP di Java membantu membuat kode lebih modular, reusable, dan mudah dikembangkan.
2. Empat pilar OOP (Encapsulation, Inheritance, Polymorphism, Abstraction) adalah fondasi utama desain perangkat lunak modern.
3. Pemahaman mendalam terhadap class, object, constructor, dan interface sangat penting sebelum mempelajari konsep lanjutan seperti Exception Handling, Generics, dan Design Patterns.

---

**Referensi:**

* [Oracle Java Official Docs](https://docs.oracle.com/javase/tutorial/java/concepts/)
* [GeeksforGeeks - OOP in Java](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/)
* [Programiz Java OOP Guide](https://www.programiz.com/java-programming/oops)
* [Baeldung Java Tutorials](https://www.baeldung.com/java-tutorial)
