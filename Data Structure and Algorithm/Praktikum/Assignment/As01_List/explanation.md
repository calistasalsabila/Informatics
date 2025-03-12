# 🖥️ Demo: ListProgrammingLanguage in Java

## 📌 Introduction
This program implements a **list of programming languages** using `LinkedList` in Java. It provides features to **display, add, remove, search, and sort** programming languages in the list.

## 🎯 Purpose
The purpose of this program is to practice using **LinkedList** in Java and apply various **data manipulation operations** such as **adding, removing, searching, and sorting** elements.

---

## 📜 Code Breakdown

### 1️⃣ Importing Libraries
```java
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
```
- `Scanner`: Reads user input.
- `LinkedList`: Stores the list of programming languages.
- `Collections`: Used for sorting the list.

---

### 2️⃣ Declaring the Class and Variables
```java
public class ListProgrammingLanguage {
    private LinkedList<String> ProgrammingLanguage = new LinkedList<>();
    private Scanner input = new Scanner(System.in);
```
- `ProgrammingLanguage`: A `LinkedList` to store programming languages.
- `input`: A `Scanner` object to handle user input.

---

### 3️⃣ Constructor - Initializing the List
```java
public ListProgrammingLanguage() {
    ProgrammingLanguage.add("C");
    ProgrammingLanguage.add("Java");
    ProgrammingLanguage.add("Python");
    ProgrammingLanguage.add("C++");
    ProgrammingLanguage.add("JavaScript");
}
```
The constructor initializes the list with some default programming languages.

---

### 4️⃣ Displaying the List
```java
public void displayItems() {
    System.out.println("\nProgramming Languages: " + ProgrammingLanguage);
}
```
This function prints the list of programming languages.

---

### 5️⃣ Waiting for User Input Before Returning to Menu
```java
public void returnToMenu(){
    System.out.println("\n*Press enter to return to menu");
    input.nextLine();
}
```
This function pauses execution and waits for the user to press **Enter** before returning to the menu.

---

### 6️⃣ Adding a Programming Language
```java
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
```
This function **adds a new programming language** to the list **only if it does not already exist**.

---

### 7️⃣ Removing a Programming Language
```java
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
        removeAll();
    } else if (choice == 2) {
        removeSpecificItem();
    } else {
        System.out.println("Operation canceled.");
    }
}
```
This function provides options to **remove all languages** or **remove a specific language** from the list.

---

### 8️⃣ Searching for a Programming Language
```java
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
```
This function **checks if a programming language is in the list**.

---

### 9️⃣ Sorting the List Alphabetically
```java
public void sortItems() {
    System.out.println("Before sorting: " + ProgrammingLanguage);
    Collections.sort(ProgrammingLanguage); 
    System.out.println("Sorting the list alphabetically..");
    System.out.println("After sorting list: " + ProgrammingLanguage);
}
```
This function **sorts the list alphabetically** using `Collections.sort()`.

---

### 🔟 Main Menu
```java
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
        System.out.print("Choose an option (must be a number): ");

        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1: list.displayItems(); break;
            case 2: list.addItem(); break;
            case 3: list.removeItem(); break;
            case 4: list.removeSpecificItem(); break;
            case 5: list.searchItem(); break;
            case 6: list.sortItems(); break;
            case 7: System.out.println("Thanks for using this program! 😊"); return;
            default: System.out.println("Invalid.");
        }
    }
}
```
This is the **main menu** that runs the program and allows users to choose different operations.

---

## 🎉 Conclusion
This Java program demonstrates how to use a **LinkedList** for managing a list of programming languages with basic operations like **adding, removing, searching, and sorting**. 🚀
