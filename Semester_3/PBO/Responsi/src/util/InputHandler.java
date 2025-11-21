package util;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputHandler {

    private Scanner scanner = new Scanner(System.in);

    public int getInt(String prompt) {
        System.out.print(prompt + " >> ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("error: masukin angka");
            scanner.nextLine();
            return -1;
        }
    }

    public String getString(String prompt) {
        System.out.print(prompt + " >> ");
        return scanner.next();
    }
}
