import java.util.Scanner;

import controller.GameController;

public class Responsi1_PPBO_L0124092_CalistaSalsabila {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---JavaG---");
        System.out.print("Ready? (y/n) >> ");

        char pilihan = scanner.next().charAt(0);

        if (pilihan == 'y' || pilihan == 'Y') {
            GameController game = new GameController();
            game.run();
        } else {
            System.out.println("Back when you are ready :).");
        }
        
        scanner.close();
    }
}

