# Sudoku Solver

A beginner-friendly Java implementation of a 9x9 Sudoku solver using the **Backtracking** algorithm.

## Problem

Fill the empty cells (`.`) in a 9x9 Sudoku board so that every row, every column, and every 3x3 sub-box contains the digits 1-9 exactly once.

The assignment guarantees that the input board has exactly one solution.

## How it works

1. Find an empty cell (`.`).
2. Try each digit from `1` to `9`.
3. Use `isSafe()` to check the row, column, and 3x3 sub-box.
4. If the digit is valid, place it and call `solveSudoku()` recursively.
5. If that choice does not lead to a solution, reset the cell to `.` and try another digit.

## Files

- `Main.java` - complete Java program.
- `sample-input.txt` - sample Sudoku board.
- `sample-output.txt` - expected solution for the sample board.

## Compile and run

```bash
javac Main.java
java Main
```

Paste the 9 rows from `sample-input.txt` when prompted.

## Sample input

```text
53..7....
6..195...
.98....6.
8...6...3
4..8.3..1
7...2...6
.6....28.
...419..5
....8..79
```

## Expected output

```text
Solved Sudoku:
5 3 4 6 7 8 9 1 2
6 7 2 1 9 5 3 4 8
1 9 8 3 4 2 5 6 7
8 5 9 7 6 1 4 2 3
4 2 6 8 5 3 7 9 1
7 1 3 9 2 4 8 5 6
9 6 1 5 3 7 2 8 4
2 8 7 4 1 9 6 3 5
3 4 5 2 8 6 1 7 9
```

## Complexity

Let `E` be the number of empty cells.

- **Time:** Worst-case exponential; a simple upper-bound expression is `O(9^E x 81)`.
- **Auxiliary space:** `O(E)` for the recursion stack. The input board is modified in place.

## Input validation

The program checks that each row has exactly 9 characters and that each cell contains `1`-`9` or `.`. It does not separately validate conflicts among the initial clues; the assignment guarantees a valid board with one solution.

## Language

Java
