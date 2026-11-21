import java.util.Scanner;

public class Main {

    // Check whether a number can be placed in this cell.
    static boolean isSafe(char[][] board, int row, int col, char number) {

        // Check the same row and column.
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return false;
            }
        }

        // Find the top-left corner of the 3x3 box.
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // Check all cells inside that 3x3 box.
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    // Solve the Sudoku using backtracking.
    static boolean solveSudoku(char[][] board) {

        // Search for an empty cell.
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    // Try each number from 1 to 9.
                    for (char number = '1'; number <= '9'; number++) {

                        if (isSafe(board, row, col, number)) {

                            // Place the number temporarily.
                            board[row][col] = number;

                            // If the rest of the board is solved, finish.
                            if (solveSudoku(board)) {
                                return true;
                            }

                            // The choice did not work, so undo it.
                            board[row][col] = '.';
                        }
                    }

                    // No number worked in this empty cell.
                    return false;
                }
            }
        }

        // There are no empty cells left.
        return true;
    }

    // Display the completed Sudoku board.
    static void printBoard(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];

        System.out.println("Enter the Sudoku board (9 rows):");
        System.out.println("Use digits 1-9 and dot (.) for empty cells.");

        // Read all 9 rows.
        for (int row = 0; row < 9; row++) {
            String line = sc.next();

            if (line.length() != 9) {
                System.out.println("Each row must contain exactly 9 characters.");
                sc.close();
                return;
            }

            for (int col = 0; col < 9; col++) {
                char cell = line.charAt(col);

                if (cell != '.' && (cell < '1' || cell > '9')) {
                    System.out.println("Use only digits 1-9 or dot (.).");
                    sc.close();
                    return;
                }

                board[row][col] = cell;
            }
        }

        // Solve and print the board.
        if (solveSudoku(board)) {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }

        sc.close();
    }
}
