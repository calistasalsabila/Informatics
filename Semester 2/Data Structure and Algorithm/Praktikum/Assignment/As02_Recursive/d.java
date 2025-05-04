import java.util.*;

public class d {
    public static int hitungVokal(String s) {
        if (s.isEmpty())
            return 0;

        char c = Character.toLowerCase(s.charAt(0)); 
        if (c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o') {
            return 1 + hitungVokal(s.substring(1));
        } else {
            return hitungVokal(s.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(hitungVokal("lorem ipsum dolor sit amet fermentum egestas luctus praesent torquent justo."));
    }
}
