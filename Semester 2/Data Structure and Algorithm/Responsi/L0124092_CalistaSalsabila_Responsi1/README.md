# 📚 Library Management System in Java

## 📌 Description
A simple console-based Java application for managing a library. It allows users to add, search, borrow, and return books. The system uses various data structures to simulate a real-world library management workflow.

## 🎯 Features
- Add, search, and remove books by ISBN
- Group and search books by genre
- Borrow and return system with:
  - Borrower tracking (using `HashMap`)
  - Return history (using `Stack`)
  - Queue for waiting borrowers (using `Queue`)
- Catalog organized by genre (using `TreeMap`)
- ISBN indexing with binary search tree
- Validation and exception handling for robust input

---

## 🧠 Data Structures Used

| No | Structure      | Java Class         | Role                                                                 |
|----|----------------|--------------------|----------------------------------------------------------------------|
| 1  | Binary Tree    | `BinaryTree`       | Indexing and searching ISBNs in-order                                |
| 2  | HashSet        | `ISBNSet`          | Ensure uniqueness of ISBNs                                           |
| 3  | ArrayList      | `BookList`         | Store list of all book objects                                       |
| 4  | Stack          | `BookStack`        | Track return history in LIFO order                                   |
| 5  | HashMap        | `BorrowerMap`      | Map borrower IDs to borrowed book ISBNs                              |
| 6  | Queue          | `BorrowQueue`      | Hold borrower queue when books are not available                     |
| 7  | TreeMap        | `CatalogTreeMap`   | Catalog books by genre in sorted order                               |



---

## ⚙️ How to Use
1. Run the `App.java` file
2. Choose menu options:
   - `1`: Add Book (requires ISBN, title, genre)
   - `2`: Search Book by ISBN
   - `3`: Display all books
   - `4`: Borrow Book (if available or go to queue)
   - `5`: Return Book (returns and optionally lends to next in queue)
   - `6`: Show Return History (LIFO)
   - `7`: Show Active Borrowers
   - `8`: Show Waiting Queue
   - `9`: Display catalog grouped by genre
   - `10`: Search book by genre
   - `11`: Remove book from system
   - `12`: Print all ISBNs in-order from BST
   - `13`: Exit

---

## 📷 Example Output (Console)
```bash
=== Aplikasi Manajemen Perpustakaan ===

Menu:
1. Tambah Buku
2. Cari Buku (berdasarkan ISBN)
...
Pilih menu (1-13): 1
Masukkan ISBN: 12345
Masukkan Judul: Laskar Pelangi
Masukkan Genre: Fiksi
Buku berhasil ditambahkan.
```

---

## 🧩 Complexity Analysis (Sample)

| No | Part                       | File:Line Range      | Time Complexity |
|----|----------------------------|-----------------------|------------------|
| 1  | insert() in BinaryTree     | `BinaryTree.java:20`  | O(log n) avg, O(n) worst |
| 2  | getBookByISBN()            | `BookList.java:17`    | O(n)             |
| 3  | returnBook() + queue proc  | `App.java:138-152`    | O(1) + O(1)      |

---

## 🧪 Example Classes Overview

### 📦 Book.java
```java
public class Book {
    private final String isbn, title, genre;
    // Constructor, getters, toString()
}
```

### 🌲 BinaryTree.java
```java
public class BinaryTree {
    public void insert(String isbn);
    public boolean search(String isbn);
    public void delete(String isbn);
    public void printInOrder();
}
```

... and similar structure for `BookStack`, `BorrowerMap`, `CatalogTreeMap`, etc.

---

## 🧠 Future Improvements
- Add file/database persistence for book & borrower data
- Add book quantity & multi-borrower per book support
- GUI interface with JavaFX or Swing
- Logging and testing framework

---


