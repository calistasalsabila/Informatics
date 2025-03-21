# 📌 Big O Notation - Complete Guide

Big O notation is a mathematical notation used to describe the efficiency of an algorithm in terms of time and space complexity. It helps us understand how an algorithm performs as input size increases. 🚀

## 📖 Table of Contents
1. [Introduction to Big O](#introduction-to-big-o)
2. [Worst-Case Analysis](#worst-case-analysis)
3. [Common Big O Complexities](#common-big-o-complexities)
4. [Rules in Big O](#rules-in-big-o)
5. [Time Complexity: O, Ω, and Θ](#time-complexity-o-Ω-and-Θ)
6. [Big O Examples](#big-o-examples)

---

## 🔍 1. Introduction to Big O
Big O notation allows us to analyze how an algorithm scales its performance as input size (**n**) increases. Big O only considers the most significant factor in an expression to determine efficiency.

Example:
- If an algorithm requires **5n + 10** operations, we simplify it to **O(n)** because constants are ignored in Big O.

---

## ⚠️ 2. Worst-Case Analysis
Big O focuses on the **worst-case scenario**, ensuring the algorithm remains efficient even for the largest inputs.

Example:
- Searching for an element in an unordered array (Linear Search) has **O(n)** complexity in the worst case.
- Searching in a Binary Search Tree (BST) has **O(log n)** complexity if balanced, but can become **O(n)** in the worst case (unbalanced tree).

---

## 📊 3. Common Big O Complexities
Here are some common time complexities along with examples:

| Big O Notation | Complexity Type | Example |
|-------------|------------------|---------|
| **O(1)** | Constant Time | Accessing an array element by index |
| **O(log n)** | Logarithmic Time | Binary Search |
| **O(n)** | Linear Time | Iterating through an array |
| **O(n log n)** | Log-Linear Time | Merge Sort, QuickSort (average case) |
| **O(n²)** | Quadratic Time | Nested loops (Bubble Sort, Selection Sort) |
| **O(2ⁿ)** | Exponential Time | Fibonacci (naïve recursion) |
| **O(n!)** | Factorial Time | Traveling Salesman Problem |

---

## 📝 4. Rules in Big O
Some key rules in simplifying Big O notation:

### 🎯 Rule 1: Drop Constants
- Example: **O(5n) → O(n)**, **O(1000) → O(1)**
- Constant factors are ignored as they do not affect scalability.

### 🎯 Rule 2: Drop Non-Dominant Terms
- Example: **O(n² + n) → O(n²)**
- Only consider the most significant term when **n** grows.

---

## ⏳ 5. Time Complexity: O, Ω, and Θ
In algorithm complexity analysis, we often use three main notations:

| Notation | Description |
|--------|-----------|
| **O (Big O, Upper Bound)** | Worst-case complexity, how slow an algorithm can run. |
| **Ω (Big Omega, Lower Bound)** | Best-case complexity, how fast an algorithm can run. |
| **Θ (Theta, Tight Bound)** | Average-case complexity, showing both upper and lower bounds of the algorithm. |

Example in Bubble Sort:
- **O(n²)** (Worst case: reversed array)
- **Ω(n)** (Best case: already sorted array)
- **Θ(n²)** (Average complexity)

---

## 🛠️ 6. Big O Examples

### 📌 Example 1: O(n) - Linear Time
```java
// Iterating through an array
public class LinearExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int num : arr) {
            System.out.println(num); // O(n)
        }
    }
}
```

### 📌 Example 2: O(1) - Constant Time
```java
// Accessing an element by index
public class ConstantExample {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        System.out.println(arr[2]); // O(1)
    }
}
```

### 📌 Example 3: O(log n) - Logarithmic Time
```java
// Binary Search (logarithmic complexity)
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Not found
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(arr, 5)); // Output: 2
    }
}
```

### 📌 Example 4: O(n²) - Quadratic Time
```java
// Nested loops (Bubble Sort)
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        bubbleSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

---

## 🎯 Conclusion
Big O notation helps us analyze algorithm efficiency and choose the best one for our needs. Understanding complexity is crucial in coding interviews and real-world applications.

### 🚀 Key Takeaways
✅ Drop constants and non-dominant terms.  
✅ Prefer algorithms with **O(1), O(log n), or O(n)**.  
✅ Understand worst-case scenarios in algorithm design.  

Happy Coding! 🎉
![alt text](image-1.png)

