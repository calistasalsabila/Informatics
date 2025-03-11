#include <stdio.h>
#include <math.h>
#include "math_operations.h"

int main(){
    int a = 0, b = 0;

    printf("Masukkan angka pertama dan kedua (beri spasi antara yang pertama dan yang kedua):\n");
    scanf("%d %d", &a, &b);
    
    printf("Hasil pertambahan: %d", add(a, b));
    printf("\nHasil pengurangan: %d", subtract(a, b));
    printf("\nHasil perkalian: %d\n", multiply(a, b));

    double hasil_bagi = divide(a, b);
    if (isnan(hasil_bagi)) {
        printf("Hasil pembagian: Tidak Terdefinisi\n");
    } else {
        printf("Hasil pembagian: %.3f", hasil_bagi);
    }

    return 0;
}
