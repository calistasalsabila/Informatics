public class f {
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("x"));
        System.out.println(isPalindrome("aa"));
        System.out.println(isPalindrome("ab"));
        System.out.println(isPalindrome("ini"));
        System.out.println(isPalindrome("itu"));
        System.out.println(isPalindrome("anna"));
        System.out.println(isPalindrome("ibu ratna antar ubi"));
        System.out.println(isPalindrome("rumah murah"));
        System.out.println(isPalindrome("aku suka rajawali bapak apabila wajar aku suka"));
    }
}
