public class g {
    public static String toBinary(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        System.out.println(toBinary(0));
        System.out.println(toBinary(1));
        System.out.println(toBinary(512));
        System.out.println(toBinary(1697));
        System.out.println(toBinary(1048575));
    }
}
