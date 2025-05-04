#include <iostream>
using namespace std;

int jumlah_digit(int n) {
    if (n < 10){ 
        return n;
    }
    else{
        return (n % 10) + jumlah_digit(n / 10);
    }
}
// Fungsi main() di bawah tidak boleh diubah!
int main(){
    cout << jumlah_digit(1982304556) << endl;
    return 0;
}
