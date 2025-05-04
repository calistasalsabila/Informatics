#include <stdio.h>

int main() {
    int a, r, n;
    int rTotal = 1;
    
    printf("Selamat datang di program penjumlahan deret Geometri!\n");
    
    printf("Masukkan angka dari suku pertama (a)= ");
    scanf("%d", &a);
    
    printf("Masukkan rasio (r)= ");
    scanf("%d", &r);
    
    printf("Masukkan banyaknya suku (n)= ");
    scanf("%d", &n);
    
    for(int i = 1; i <= n; i++){
        rTotal = rTotal * r;
    }
    
    if (r > 1){
        int total = (a * (rTotal - 1)) / (r - 1);
        printf("Total deret dengan %d suku adalah %d", n, total);
    }
    else if(r < 1){
        int total = (a * (1 - rTotal)) / (1 - r);
        printf("Total deret dengan %d suku adalah %d", n, total);
    }
    else{
        printf("Nilai r anda = 1, maka tidak dapat digunakan pada rumus");
    }
    
    return 0;
}
