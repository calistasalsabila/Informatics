public class e {
    public static int jumlahDigit(int n) {
        if (n < 10) {
            return n;
        } else {
            return (n % 10) + jumlahDigit(n / 10);
        }
    }

    public static void main(String[] args) {
        System.out.println(jumlahDigit(1982304556));
    }
}
