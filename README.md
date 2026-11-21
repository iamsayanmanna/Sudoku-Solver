# Sudoku Solver

A Java command-line application that solves a standard **9 × 9 Sudoku puzzle** using the backtracking algorithm.

## Overview

The solver fills empty cells, represented by `.`, while following the three standard Sudoku constraints:

- Each row must contain the digits 1–9 without repetition.
- Each column must contain the digits 1–9 without repetition.
- Each 3 × 3 sub-grid must contain the digits 1–9 without repetition.

The board is updated in place as the solution is searched.

## Features

- Solves 9 × 9 Sudoku puzzles.
- Uses recursive backtracking to explore valid choices.
- Checks row, column, and 3 × 3 sub-grid constraints before placing a digit.
- Restores a cell when a choice does not lead to a solution.
- Validates the length and allowed characters of each input row.
- Prints the completed board or reports when no solution is found.

## Requirements

- Java Development Kit (JDK) installed.
- A terminal or command prompt.

Check your Java installation:

```bash
java -version
javac -version
```

## Getting Started

Clone the repository:

```bash
git clone https://github.com/iamsayanmanna/Sudoku-Solver.git
cd Sudoku-Solver
```

Compile and run:

```bash
javac Main.java
java Main
```

## Input Format

Enter exactly 9 lines, each containing exactly 9 characters.

- Use digits `1` through `9` for filled cells.
- Use a dot (`.`) for an empty cell.
- Do not add spaces between characters in a row.

## Example

**Input**

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

**Output**

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

## Algorithm

The solver uses backtracking:

1. Find the next empty cell.
2. Try digits from `1` to `9`.
3. Check whether a digit is valid in the cell.
4. If valid, place it and recursively solve the remaining board.
5. If the recursive search fails, reset the cell to `.` and try the next digit.
6. If no empty cells remain, the puzzle is solved.

## Complexity Analysis

Let `E` be the number of empty cells.

| Measure | Complexity |
| --- | --- |
| Time | Worst-case exponential; a simple upper-bound expression is `O(9^E × 81)` |
| Auxiliary space | `O(E)` for the recursion stack |

The 9 × 9 board is modified in place.

## Input Assumptions and Limitations

- The program checks row length and allowed input characters.
- It does not separately validate conflicts among the initially provided clues.
- The solver is designed for standard 9 × 9 Sudoku puzzles. The puzzle used in the example has a unique solution.

## Project Structure

```text
Sudoku-Solver/
├── Main.java
├── sample-input.txt
└── sample-output.txt
```

## License

No license has currently been specified for this repository.
