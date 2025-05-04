# 🎨 List Programming Language in Java Program

## 📌 Introduction
This Java program implements a **list of programming languages** using `LinkedList`. It allows users to **display, add, remove, search, and sort** programming languages interactively.

## 🎯 Purpose
The purpose of this program is to practice working with **LinkedList** in Java and perform various **list operations** such as:
- Adding new elements
- Removing specific or all elements
- Searching for elements
- Sorting elements alphabetically

---

## 📜 Code Breakdown

### 1⃣ Importing Libraries
```java
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
```
- `Scanner`: Reads user input.
- `LinkedList`: Stores the programming languages.
- `Collections`: Used for sorting the list.

---

### 2⃣ Declaring the Class and Variables
```java
public class ListProgrammingLanguage {
    private LinkedList<String> programmingLanguage = new LinkedList<>();
    private Scanner input = new Scanner(System.in);
```
- `programmingLanguage`: A `LinkedList` to store programming languages.
- `input`: A `Scanner` object to handle user input.

---

### 3⃣ Constructor - Initializing the List
```java
public ListProgrammingLanguage() {
    programmingLanguage.add("C");
    programmingLanguage.add("Java");
    programmingLanguage.add("Python");
    programmingLanguage.add("C++");
    programmingLanguage.add("JavaScript");
}
```
The constructor initializes the list with some predefined programming languages.

---

### 4⃣ Displaying the List
```java
public void displayItems() {
    System.out.println("\nProgramming Languages: " + programmingLanguage);
}
```
This function prints the list of programming languages.

---

### 5⃣ Adding a Programming Language
```java
public void addItem() {
    displayItems();
    System.out.print("Add programming language to list: ");
    String newLanguage = input.nextLine().trim();  

    boolean exists = programmingLanguage.stream()
                    .anyMatch(subProLang -> subProLang.equalsIgnoreCase(newLanguage));

    if (exists) {
        System.out.println(newLanguage + " is already in the list! Can't duplicate.");
    } else {
        programmingLanguage.add(newLanguage);
        System.out.println(newLanguage + " has been added.");
        displayItems();
    }
}
```
This function **adds a new programming language** to the list **if it does not already exist**.

---

### 6⃣ Removing a Programming Language
```java
public void removeItem() {
    if (programmingLanguage.isEmpty()) {
        System.out.println("List is empty, no item to remove.");
        return;
    }
    System.out.println("\n---------------");
    System.out.println("Removal Options:");
    System.out.println("----------------");
    System.out.println("1. Remove all programming languages");
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
        programmingLanguage.clear();
        System.out.println("All items have been removed.");
    } else if (choice == 2) {
        removeSpecificItem();
    } else {
        System.out.println("Operation canceled.");
    }
}
```
This function provides options to **remove all languages** or **remove a specific language** from the list.

---

### 7⃣ Searching for a Programming Language
```java
public void searchItem() {
    System.out.print("Enter name of programming language to search: ");
    String languageName = input.nextLine().trim();

    boolean found = programmingLanguage.stream()
                    .anyMatch(subProLang -> subProLang.equalsIgnoreCase(languageName));

    if (found) {
        System.out.println(languageName + " found in the list.");
    } else {
        System.out.println(languageName + " is not in the list.");
    }
}
```
This function **checks if a programming language exists** in the list.

---

### 8⃣ Sorting the List Alphabetically
```java
public void sortItems() {
    System.out.println("Before sorting: " + programmingLanguage);
    Collections.sort(programmingLanguage);
    System.out.println("Sorting the list alphabetically...");
    System.out.println("After sorting: " + programmingLanguage);
}
```
This function **sorts the list alphabetically** using `Collections.sort()`.

---

###  Main Menu
```java
public static void main(String[] args) {
    ListProgrammingLanguage list = new ListProgrammingLanguage();
    Scanner input = new Scanner(System.in);
    
    while (true) {
        System.out.println("========================================");
        System.out.println("\nWelcome to List of Programming Language\n");
        System.out.println("========================================");
        System.out.println("\nMenu:");
        System.out.println("1. Display Programming Languages");
        System.out.println("2. Add Programming Language");
        System.out.println("3. Remove Programming Language");
        System.out.println("4. Search Programming Language");
        System.out.println("5. Sort Programming Language");
        System.out.println("6. Exit");
        System.out.print("Choose an option (1-6): ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number between 1-6.");
            input.next();
            continue;
        }

        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1: list.displayItems(); break;
            case 2: list.addItem(); break;
            case 3: list.removeItem(); break;
            case 4: list.searchItem(); break;
            case 5: list.sortItems(); break;
            case 6: System.out.println("Thanks for using this program!"); return;
            default: System.out.println("Invalid choice, please enter 1-6");
        }
    }
}
```
This is the **main menu** that runs the program and allows users to choose different operations.

---

## 🎉 Conclusion
This Java program demonstrates how to use a **LinkedList** for managing a list of programming languages with basic operations like **adding, removing, searching, and sorting**. 🚀

