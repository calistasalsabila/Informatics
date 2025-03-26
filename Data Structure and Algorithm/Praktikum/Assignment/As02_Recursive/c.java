
public class c {
    public static void cetakMenurun(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        cetakMenurun(n - 1);
    }

    public static void main(String[] args) {
        cetakMenurun(10);
    }
}
