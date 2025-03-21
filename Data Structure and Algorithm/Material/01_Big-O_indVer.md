# 📌 Notasi Big O - Panduan Lengkap

Notasi Big O adalah notasi matematis yang digunakan untuk menggambarkan efisiensi suatu algoritma dalam hal kompleksitas waktu dan ruang. Ini membantu kita memahami bagaimana suatu algoritma bekerja saat ukuran input bertambah. 🚀

## 📖 Daftar Isi
1. [Pengenalan Big O](#pengenalan-big-o)
2. [Analisis Kasus Terburuk](#analisis-kasus-terburuk)
3. [Kompleksitas Big O Umum](#kompleksitas-big-o-umum)
4. [Aturan dalam Big O](#aturan-dalam-big-o)
5. [Kompleksitas Waktu: O, Ω, dan Θ](#kompleksitas-waktu-o-Ω-dan-Θ)
6. [Contoh Big O](#contoh-big-o)

---

## 🔍 1. Pengenalan Big O
Notasi Big O memungkinkan kita untuk menganalisis bagaimana suatu algoritma menskalakan performanya dengan bertambahnya ukuran input (**n**). Big O hanya mempertimbangkan faktor paling signifikan dalam ekspresi untuk menentukan efisiensinya.

Contoh:
- Jika suatu algoritma membutuhkan **5n + 10** operasi, kita sederhanakan menjadi **O(n)** karena konstanta diabaikan dalam Big O.

---

## ⚠️ 2. Analisis Kasus Terburuk
Big O fokus pada **skenario kasus terburuk**, yang memastikan algoritma tetap efisien bahkan untuk input terbesar.

Contoh:
- Mencari elemen dalam array yang tidak terurut (Linear Search) memiliki kompleksitas **O(n)** dalam kasus terburuk.
- Mencari dalam Binary Search Tree (BST) memiliki kompleksitas **O(log n)** jika seimbang, tetapi bisa menjadi **O(n)** dalam kasus terburuk (pohon tidak seimbang).

---

## 📊 3. Kompleksitas Big O Umum
Berikut adalah beberapa kompleksitas waktu umum beserta contohnya:

| Notasi Big O | Jenis Kompleksitas | Contoh |
|-------------|------------------|---------|
| **O(1)** | Waktu Konstan | Mengakses elemen array dengan indeks |
| **O(log n)** | Waktu Logaritmik | Binary Search |
| **O(n)** | Waktu Linear | Melakukan iterasi dalam array |
| **O(n log n)** | Waktu Log-Linear | Merge Sort, QuickSort (rata-rata) |
| **O(n²)** | Waktu Kuadratik | Nested loops (Bubble Sort, Selection Sort) |
| **O(2ⁿ)** | Waktu Eksponensial | Fibonacci (rekursi naïf) |
| **O(n!)** | Waktu Faktorial | Traveling Salesman Problem |

---

## 📝 4. Aturan dalam Big O
Beberapa aturan utama dalam menyederhanakan notasi Big O:

### 🎯 Aturan 1: Hilangkan Konstanta
- Contoh: **O(5n) → O(n)**, **O(1000) → O(1)**
- Faktor konstanta diabaikan karena tidak mempengaruhi skalabilitas.

### 🎯 Aturan 2: Hilangkan Istilah Non-Dominan
- Contoh: **O(n² + n) → O(n²)**
- Hanya mempertimbangkan istilah paling signifikan saat **n** membesar.

---

## ⏳ 5. Kompleksitas Waktu: O, Ω, dan Θ
Dalam analisis kompleksitas algoritma, kita sering menggunakan tiga notasi utama:

| Notasi | Deskripsi |
|--------|-----------|
| **O (Big O, Upper Bound)** | Kompleksitas kasus terburuk, seberapa lambat algoritma bisa berjalan. |
| **Ω (Big Omega, Lower Bound)** | Kompleksitas kasus terbaik, seberapa cepat algoritma bisa berjalan. |
| **Θ (Theta, Tight Bound)** | Kompleksitas rata-rata, menunjukkan batas atas dan bawah dari algoritma. |

Contoh pada Bubble Sort:
- **O(n²)** (Kasus terburuk: array terbalik)
- **Ω(n)** (Kasus terbaik: array sudah terurut)
- **Θ(n²)** (Kompleksitas rata-rata)

---

## 🛠️ 6. Contoh Big O

### 📌 Contoh 1: O(n) - Waktu Linear
```java
// Melakukan iterasi dalam array
public class LinearExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int num : arr) {
            System.out.println(num); // O(n)
        }
    }
}
```

### 📌 Contoh 2: O(1) - Waktu Konstan
```java
// Mengakses elemen dengan indeks
public class ConstantExample {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        System.out.println(arr[2]); // O(1)
    }
}
```

### 📌 Contoh 3: O(log n) - Waktu Logaritmik
```java
// Binary Search (kompleksitas logaritmik)
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Tidak ditemukan
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(arr, 5)); // Output: 2
    }
}
```

### 📌 Contoh 4: O(n²) - Waktu Kuadratik
```java
// Nested loops (Bubble Sort)
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        bubbleSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

---

## 🎯 Kesimpulan
Notasi Big O membantu kita menganalisis efisiensi algoritma dan memilih yang terbaik untuk kebutuhan kita. Memahami kompleksitas ini sangat penting dalam wawancara coding dan penerapan nyata.

### 🚀 Poin Penting
✅ Hilangkan konstanta dan istilah non-dominan.  
✅ Usahakan memilih algoritma dengan **O(1), O(log n), atau O(n)**.  
✅ Pahami skenario kasus terburuk dalam desain algoritma.  

Happy Coding! 🎉
![alt text](image-1.png)

