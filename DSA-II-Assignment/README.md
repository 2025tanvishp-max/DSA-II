# DSA-II Programming Assignment 1
## Two-Pointer Technique

**Student:** Tanvish Gangadhar Poojari  
**Roll Number:** 150096725203  
**Class:** Demis Hassabis  
**Subject:** DSA-II  
**Languages:** C++, Java, Python

---

## 1. Project Overview

This project implements two array problems using brute-force and optimized approaches.

### Part A – Remove Duplicates from a Sorted Array
- Brute Force: Uses a separate list to store unique elements.
- Optimized: Uses slow and fast pointers to modify the array in place.

### Part B – Pair Sum in a Sorted Array
- Brute Force: Checks every possible pair using nested loops.
- Optimized: Uses two pointers starting from opposite ends of the array.

## 2. Project Structure

```text
DSA-II-ASSIGNMENT/
│
├── C++/
│   └── main.cpp
│
├── Java/
│   └── Main.java
│
├── Python/
│   └── main.py
│
└── README.md
```

## 3. Requirements

- C++ compiler supporting C++17
- Java JDK
- Python 3
- Visual Studio Code or any suitable code editor

## 4. How to Run

### C++

```bash
cd "C++"
g++ -std=c++17 main.cpp -o main
./main
```

### Java

```bash
cd Java
javac Main.java
java Main
```

### Python

```bash
cd Python
python3 main.py
```

## 5. Algorithm Complexity

| Algorithm | Time Complexity | Auxiliary Space |
|---|---|---|
| Remove Duplicates – Brute Force | O(n) | O(n) |
| Remove Duplicates – Optimized | O(n) | O(1) |
| Pair Sum – Brute Force | O(n²) | O(1) |
| Pair Sum – Optimized | O(n) | O(1) |

## 6. Important Notes

- Both problems assume that the input array is sorted.
- Array indices are zero-based.
- The optimized duplicate-removal algorithm modifies the original array.
- The optimized pair-sum algorithm uses the sorted order to move its pointers efficiently.
- If no valid pair exists, the program returns `(-1, -1)`.

**Assignment test-case correction:** For the array `[1, 3, 5, 8]` and target `7`, no valid pair exists because `1 + 5 = 6`. The correct result is `(-1, -1)`. If the intended target was `6`, the correct pair is `(0, 2)`.

## 7. Conclusion

This assignment demonstrates how the two-pointer technique can improve the efficiency of array operations. It also compares brute-force and optimized solutions across C++, Java and Python.