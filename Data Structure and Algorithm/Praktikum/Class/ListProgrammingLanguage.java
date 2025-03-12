import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;

public class ListProgrammingLanguage {
    private LinkedList<String> ProgrammingLanguage = new LinkedList<>();
    private Scanner input = new Scanner(System.in); 

    public ListProgrammingLanguage() {
        ProgrammingLanguage.add("C");
        ProgrammingLanguage.add("Java");
        ProgrammingLanguage.add("Python");
        ProgrammingLanguage.add("C++");
        ProgrammingLanguage.add("JavaScript");
    }

    public void displayItems() {
        System.out.println("\nProgramming Languages: " + ProgrammingLanguage);
    }

    public void returnToMenu(){
        System.out.println("\n*Press enter to return to menu");
        input.nextLine();
    }

    public void addItem() {
        displayItems();
        System.out.print("Add programming language to list: ");
        String newLanguage = input.nextLine().trim();  
    
        boolean exists = false;
        for (String subProLang : ProgrammingLanguage) {
            if (subProLang.equalsIgnoreCase(newLanguage)) { 
                exists = true;
                break;
            }
        }
    
        if (exists) {
            System.out.println(newLanguage + " is already in the list! Can't duplicate.");
        } else {
            ProgrammingLanguage.add(newLanguage);
            System.out.println(newLanguage + " has been added.");
            displayItems();
        }
    }
    

    public void removeItem() {
        if (ProgrammingLanguage.isEmpty()) {
            System.out.println("List is empty, no item to remove.");
            return;
        }
        System.out.println("\n--------------");
        System.out.println("Removal Options:");
        System.out.println("-----------------");
        System.out.println("1. Remove all programming language");
        System.out.println("2. Remove a specific programming language?");
        System.out.println("3. Cancel");
        System.out.print("Enter number 1 - 3: ");

        int choice = input.nextInt();
        input.nextLine(); 

        if (choice == 1) {
            displayItems();
            System.out.print("removing....");
            removeAll();
            displayItems();
        } else if (choice == 2) {
            removeSpecificItem();
        } else {
            System.out.println("Operation canceled.");
        }
    }

    private void removeAll() {
        ProgrammingLanguage.clear();
        System.out.println("All items have been removed.");
    }

    public void removeSpecificItem() {
        displayItems();
        System.out.println("Warning! This is case-sensitive, please be careful");
        System.out.print("Enter language to remove: ");
        String LanguageName = input.nextLine();
        if (ProgrammingLanguage.remove(LanguageName)) {
            System.out.println(LanguageName + " has been removed.");
            displayItems();
        } else {
            System.out.println(LanguageName + " isnt in the list.");
        }
    }

    public void searchItem() {
        System.out.print("Enter name of programming language that you search: ");
        String LanguageName = input.nextLine().trim();
    
        boolean found = false;
        for (String subProLang : ProgrammingLanguage) {
            if (subProLang.equalsIgnoreCase(LanguageName)) { 
                found = true;
                break;
            }
        }
    
        if (found) {
            System.out.println(LanguageName + " found, it's in the list.");
        } else {
            System.out.println(LanguageName + " isn't found.");
        }
    }
    

    public void sortItems() {
        System.out.println("Before sorting: " + ProgrammingLanguage);
        Collections.sort(ProgrammingLanguage); 
        System.out.println("Sorting the list alphabetically.. (capital letters are prioritized)");
        System.out.println("After sorting list: " + ProgrammingLanguage);
    }

   

    public static void main(String[] args) {
        ListProgrammingLanguage list = new ListProgrammingLanguage();
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.println("========================================");
            System.out.println("\nWelcome to List of Programming Language\n");
            System.out.println("========================================");
            System.out.println("\nMenu:");
            System.out.println("1. Display Programming Language in The List");
            System.out.println("2. Add Programming Language");
            System.out.println("3. Remove Programming Language");
            System.out.println("4. Remove Specific Programming Language");
            System.out.println("5. Search Programming Language");
            System.out.println("6. Sort Programming Language ");
            System.out.println("7. Esc");
            System.out.print("Choose an option (must be  a number): ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    list.displayItems();
                    list.returnToMenu();
                    break;
                case 2:
                    list.addItem();
                    list.returnToMenu();
                    break;
                case 3:
                    list.removeItem();
                    list.returnToMenu();
                    break;
                case 4:
                    list.removeSpecificItem();
                    list.returnToMenu();
                    break;
                case 5:
                    list.searchItem();
                    list.returnToMenu();
                    break;
                case 6:
                    list.sortItems();
                    list.returnToMenu();
                    break;
                case 7:
                    System.out.println("Thanks for using this program!");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid.");
            }
        }
    }
}