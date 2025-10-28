package PBO.assignment.assignment_05;

// Nama : Calista Salsabila
// NIM  : L0124092

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PPBO_05_L0124092_CalistaSalsabila {

    private static final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/[0-9]{4}$";
    private static final String PHONE_REGEX = "^(\\+|00)\\d{10,15}$";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan Tanggal Lahir (dd/mm/yyyy):");
        String tanggal = sc.nextLine().trim();

        System.out.println("Masukkan Nomor Telepon (contoh: +628... atau 00628...):");
        String hp = sc.nextLine().trim();

        System.out.println("Masukkan Email:");
        String email = sc.nextLine().trim();

        boolean tanggalValid = validateDate(tanggal);
        System.out.println(tanggalValid ? "Tanggal Lahir Valid" : "Tanggal Lahir Tidak Valid");

        boolean hpValid = validatePhone(hp);
        System.out.println(hpValid ? "Nomor HP Valid" : "Nomor HP Tidak Valid");

        boolean emailValid = validateEmail(email);
        System.out.println(emailValid ? "Email Valid" : "Email Tidak Valid");

        sc.close();
    }

    private static boolean validateDate(String s) {
        if (s == null) return false;
        Pattern p = Pattern.compile(DATE_REGEX);
        Matcher m = p.matcher(s);
        if (!m.matches()) return false;

        return true;
    }

    private static boolean validatePhone(String s) {
        if (s == null) return false;
        Pattern p = Pattern.compile(PHONE_REGEX);
        Matcher m = p.matcher(s);
        return m.matches();
    }

    private static boolean validateEmail(String s) {
        if (s == null) return false;

        if (s.length() < 5 || s.length() > 50) return false;

        char first = s.charAt(0);
        if (!Character.isLetterOrDigit(first)) return false;

        int atCount = 0;
        for (char c : s.toCharArray()) if (c == '@') atCount++;
        if (atCount != 1) return false;

        int atIndex = s.indexOf('@');
        if (s.indexOf('.', atIndex + 1) == -1) return false;

        if (s.contains(" ")) return false;

        return true;
    }
}
