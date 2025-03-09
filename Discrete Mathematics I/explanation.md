# 📌 Program Penjumlahan Deret Geometri

## 🏁 Pengertian dan Tujuan

Program ini dibuat untuk menghitung jumlah n suku pertama dari suatu deret geometri berdasarkan input yang diberikan oleh pengguna. 

Tujuan dari program ini adalah untuk membantu memahami cara kerja perhitungan deret geometri menggunakan bahasa C, serta bagaimana implementasi iterasi dan percabangan dalam proses perhitungannya.

Kode berikut merupakan bagian awal dari program:

```c
#include <stdio.h>

int main() {
    int a, r, n;
    int rTotal = 1;
```

---

## 📥 Penjelasan Input

Pada bagian ini, program meminta pengguna untuk memasukkan nilai-nilai yang diperlukan untuk menghitung deret geometri. Input yang diterima berupa bilangan bulat.

```c
printf("Masukkan angka dari suku pertama (a)= ");
scanf("%d", &a);

printf("Masukkan rasio (r)= ");
scanf("%d", &r);

printf("Masukkan banyaknya suku (n)= ");
scanf("%d", &n);
```

🔹 **Penjelasan:**
- `scanf("%d", &a);` menerima input dari pengguna untuk nilai suku pertama.
- `scanf("%d", &r);` menerima input rasio.
- `scanf("%d", &n);` menerima input banyaknya suku yang akan dijumlahkan.

Setelah mendapatkan input, program akan melakukan iterasi untuk menghitung nilai rasio pangkat n.

---

## 🔄 Iterasi I sampai ke N

Pada bagian ini, program melakukan perhitungan **r^n** dengan menggunakan perulangan for.

```c
for(int i = 1; i <= n; i++){
    rTotal = rTotal * r;
}
```

🔹 **Penjelasan:**
- `rTotal` diinisialisasi dengan nilai **1**.
- Perulangan `for` berjalan dari **1** hingga **n**.
- Setiap iterasi, `rTotal` dikalikan dengan `r` sehingga menghasilkan nilai **r^n**.

Setelah iterasi ini selesai, program akan masuk ke bagian pengambilan keputusan (`if-else`).

---

## ✅ If Pertama

Pada bagian ini, program menangani kasus **r > 1**, yang merupakan kondisi umum dalam deret geometri.

```c
if (r > 1){
    int total = (a * (rTotal - 1)) / (r - 1);
    printf("Total deret dengan %d suku adalah %d", n, total);
}
```

🔹 **Penjelasan:**
- Jika rasio `r` lebih besar dari 1, maka program menggunakan rumus jumlah n suku pertama dari deret geometri:
  
  \[ Sn = (a * (r^n - 1)) / (r - 1)\]
  
- Hasil perhitungan ditampilkan menggunakan `printf()`.

---

## 🔻 If Kedua

Bagian ini menangani kasus **r < 1**.

```c
else if(r < 1){
    int total = (a * (1 - rTotal)) / (1 - r);
    printf("Total deret dengan %d suku adalah %d", n, total);
}
```

🔹 **Penjelasan:**
- Jika `r < 1`, rumus yang digunakan sama dengan sebelumnya, hanya saja dengan sedikit perubahan untuk menghindari hasil negatif:
  
  \[Sn = a * (1 - r^n) / 1 - r\]
  
- Hasil perhitungan juga ditampilkan menggunakan `printf()`.

---

##  Else 

Bagian terakhir menangani kasus khusus **r = 1**.

```c
else{
    printf("Nilai r anda = 1, maka tidak dapat digunakan pada rumus");
}
```

🔹 **Penjelasan:**
- Jika `r = 1`, maka deret akan menjadi deret aritmetika dengan nilai yang sama di setiap sukunya.
- Rumus yang digunakan dalam program tidak dapat diaplikasikan untuk `r = 1`, sehingga program memberikan peringatan kepada pengguna.

### 🎯 Kesimpulan

Program ini merupakan implementasi sederhana dari perhitungan deret geometri dalam bahasa C. Dengan memahami setiap bagian program, kita dapat melihat bagaimana konsep iterasi dan percabangan digunakan dalam menyelesaikan permasalahan matematika.

🔥 Terima kasihh! Semoga bermanfaat! 🚀

