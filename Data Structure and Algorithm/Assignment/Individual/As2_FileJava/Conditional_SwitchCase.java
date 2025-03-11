public class Conditional_SwitchCase {
    public static void main(String[] args) {

        System.out.println("Let's increase our worship in the month of Ramadan :D");
        System.out.print("You choose ");

        int assignment = 2;

        switch (assignment) {
            case 1:
                System.out.println("Read Quran");
                break;
            case 2:
                System.out.println("Iftar");
                break;
            case 3:
                System.out.println("Tahajud");
                break;
            default:
                System.out.println("Do anything that you want");
        }
    }
}
