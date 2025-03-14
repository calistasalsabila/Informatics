import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;

public class ListProgrammingLanguage {
    private LinkedList<String> programmingLanguage = new LinkedList<>();
    private Scanner input = new Scanner(System.in); 

    public ListProgrammingLanguage() {
        programmingLanguage.add("C");
        programmingLanguage.add("Java");
        programmingLanguage.add("Python");
        programmingLanguage.add("C++");
        programmingLanguage.add("JavaScript");
    }

    public void displayItems() {
        System.out.println("\nProgramming Languages: " + programmingLanguage);
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
        for (String subProLang : programmingLanguage) {
            if (subProLang.equalsIgnoreCase(newLanguage)) { 
                exists = true;
                break;
            }
        }
    
        if (exists) {
            System.out.println(newLanguage + " is already in the list! Can't duplicate.");
        } else {
            programmingLanguage.add(newLanguage);
            System.out.println(newLanguage + " has been added.");
            displayItems();
        }
    }
    

    public void removeItem() {
        if (programmingLanguage.isEmpty()) {
            System.out.println("List is empty, no item to remove.");
            return;
        }
        System.out.println("\n---------------");
        System.out.println("Removal Options:");
        System.out.println("----------------");
        System.out.println("1. Remove all programming language");
        System.out.println("2. Remove a specific programming language");
        System.out.println("3. Cancel");
        System.out.print("Enter number 1 - 3: ");

        if (!input.hasNextInt()) {  
            System.out.println("Invalid input! Please enter a number between 1-3.");
            input.next(); 
            return; 
        }

        int choice = input.nextInt();
        input.nextLine(); 

        if (choice == 1) {
            displayItems();
            System.out.print("removing....");
            removeAll();
            displayItems();
            System.out.println("Remove All Sucess!!");
        } else if (choice == 2) {
            removeSpecificItem();
        } else {
            System.out.println("Operation canceled.");
        }
    }

    private void removeAll() {
        programmingLanguage.clear();
        System.out.println("All items have been removed.");
    }

    private void removeSpecificItem() {
        if (programmingLanguage.isEmpty()) {
            System.out.println("List is empty, nothing to remove.");
            return;
        }
        displayItems();
        
        System.out.print("Enter language to remove: ");
        
        String languageName = input.nextLine().trim();
    
        if (languageName.isEmpty()) { 
            System.out.println("Input cannot be empty!");
            return;
        }
    
        boolean removed = programmingLanguage.removeIf(subLan -> subLan.equalsIgnoreCase(languageName));
    
        if (removed) {
            System.out.println(languageName + " has been removed.");
        } else {
            System.out.println(languageName + " isn't in the list.");
        }
    
        displayItems();
    }
    
    

    public void searchItem() {
        if (programmingLanguage.isEmpty()) {
            System.out.println("List is empty, no item to search.");
            return;
        }
        System.out.print("Enter name of programming language that you search: ");
        String languageName = input.nextLine().trim();
    
        boolean found = false;
        for (String subProLang : programmingLanguage) {
            if (subProLang.equalsIgnoreCase(languageName)) { 
                found = true;
                break;
            }
        }
    
        if (found) {
            System.out.println(languageName + " found, it's in the list.");
        } else {
            System.out.println(languageName + " isn't found.");
        }
    }
    

    public void sortItems() {
        if (programmingLanguage.isEmpty()) {
            System.out.println("List is empty, nothing to sort.");
            return;
        }
        System.out.println("Before sorting: " + programmingLanguage);
        Collections.sort(programmingLanguage); 
        System.out.println("Sorting the list alphabetically..(capital letters are prioritized)");
        System.out.println("After sorting list: " + programmingLanguage);
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
            System.out.println("4. Search Programming Language");
            System.out.println("5. Sort Programming Language (capital letters are prioritized!)");
            System.out.println("6. Esc");
            System.out.print("Choose an option (must be  a number): ");

            if (!input.hasNextInt()) { 
                System.out.println("Invalid input! Please enter a number between 1-6.");
                input.next(); 
                continue; 
            }
    
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
                    list.searchItem();
                    list.returnToMenu();
                    break;
                case 5:
                    list.sortItems();
                    list.returnToMenu();
                    break;
                case 6:
                    System.out.println("Thanks for using this program!");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice please enter 1 -6");
            }
        }
    }
}
