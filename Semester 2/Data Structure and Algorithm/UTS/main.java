public class main {
    public static void methodThree() {
        System.out.println("Three");
    }

    public static void methodTwo() {
        methodThree();
        System.out.println("Two");
    }

    public static void methodOne() {
        methodTwo();
        System.out.println("BELUM PERNAH SEMUAK INI BELAJAR CODING");
    }

    public static void main(String[] args) {
        methodOne();
    }
}
