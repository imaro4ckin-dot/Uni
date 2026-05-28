# University Java Learning Journal

A personal repository tracking my Java learning journey through university coursework. It spans two semesters of structured lessons and self-directed practice projects — from basic control flow to sorting algorithms and object-oriented design.

---

## Structure

```
Uni/
├── Main.java              # Number guessing game (root entry point)
├── lesson1/               # Matrix operations
├── Lesson2/               # Control flow & input validation
├── lesson3/               # Financial tracking with HashMap
├── Lesson4/               # Sorting algorithms
├── SecondSem/             # Second semester array exercises
└── myOwnCode/             # Self-directed practice projects
```

---

## Lessons

### Lesson 1 — Matrix Operations
- **MatrixMultiplication.java** — Standard O(n³) matrix multiplication
- **MatrixElementWise.java** — Element-wise matrix addition
- **TRiangle.java** — ASCII triangle pattern generation

### Lesson 2 — Control Flow & Input Handling
- **RockPaperScissors.java** — Interactive game with input validation and random computer moves
- **EarthquakeCategorization.java** — Magnitude classification using switch expressions
- **TruthTable.java** — AND, OR, XOR, NOT logic gate implementations

### Lesson 3 — Data Structures
- **financialTask.java** — Transaction tracker using `HashMap`, supports date-based queries and transaction type filtering

### Lesson 4 — Sorting Algorithms
- **MergeSort.java** — Full merge sort implementation (O(n log n) divide-and-conquer)

### Second Semester — Array Algorithms
- **ArrayEx.java** — Three single-pass optimized algorithms:
  - `diagonalDifference()` — Absolute difference between matrix diagonals
  - `minMaxSum()` — Min/max values and their sum in one pass
  - `birthDayCakeCandles()` — Count of tallest candles in an array

---

## My Own Code

Self-directed projects built independently to reinforce concepts:

| File | Description |
|---|---|
| `SimpleBankApp.java` | OOP bank account system — deposit, withdraw, transfer using `ArrayList` and a custom `BankCode` class |
| `CinemaBooking.java` | 2D array seat management with ticket booking logic |
| `GradeAnalyzer.java` | Score filtering and type casting to compute averages |
| `ShoppingCheckout.java` | E-commerce checkout with discount logic and budget validation |
| `BonusCalculator.java` | Corporate bonus calculator based on KPI score and position level |
| `Loop.java` | String character iteration with vowel counting and replacement |

---

## Key Concepts Covered

- Primitive types, control flow, loops, and methods
- Arrays and 2D arrays
- `HashMap`, `ArrayList`, and custom classes
- Sorting algorithms (Merge Sort)
- Matrix algorithms
- Input validation with `Scanner`
- Basic OOP: encapsulation, method decomposition

---

## Setup

No build tool required. Open the project in **IntelliJ IDEA** and run any `main()` method directly.

- Language: Java 17+
- IDE: IntelliJ IDEA
- No external dependencies
