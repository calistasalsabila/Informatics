# 📌 Linked List in Java

## 📖 Introduction
A **Linked List** is a linear data structure where elements (nodes) are linked using pointers. Unlike arrays, linked lists do not have a fixed size, making them more flexible for dynamic memory allocation.

## 🎯 Purpose of Linked List
-  **Efficient insertion & deletion** 🏹
-  **Dynamic memory allocation** 📦
-  **Overcomes limitations of arrays** 🛠️
-  **Used in various data structures like stacks, queues, and graphs** 🔗

---

## 🛠️ Types of Linked List
- **🔹 Singly Linked List**: Each node has a reference to the next node only. 🔄
- **🔹 Doubly Linked List**: Each node has references to both the previous and next nodes. ⬅️➡️
- **🔹 Circular Linked List**: The last node points to the first node, forming a circle 🔁

---

## 📝 Syntax (Singly Linked List)
```java
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;
    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.display();
    }
}
```

🔹 **Explanation:**
- `Node` class represents a single node with data and a reference (`next`).
- `insert()` method adds a new node at the end.
- `display()` method prints the list.
- `main()` method tests insertion and display functions.

---

## 🚀 Example Output
```
1 -> 2 -> 3 -> null
```

---

## ⏳ Linked List Big-O Complexity
| Operation       | Linked List | Array List |
|----------------|------------|------------|
| Append         | O(1)       | O(1)       |
| Remove Last    | O(n)       | O(1)       |
| Prepend        | O(1)       | O(n)       |
| Remove First   | O(1)       | O(n)       |
| Insert         | O(n)       | O(n)       |
| Remove         | O(n)       | O(n)       |
| Lookup by Index| O(n)       | O(1)       |
| Lookup by Value| O(n)       | O(n)       |

✔️ **Best Use Case:** When frequent insertions/deletions are required 🔥

---

## 🎯 Conclusion
- 🔹 Linked Lists are powerful for **dynamic memory allocation** and **fast insertions/deletions**.
- 🔹 They are not the best for **random access** due to O(n) search time.
- 🔹 Understanding **Big-O complexities** is crucial when choosing data structures!

Happy Coding! 🚀🎉
