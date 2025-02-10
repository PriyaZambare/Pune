package basics;

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moveCount = 0;
        boolean gameRunning = true;

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (gameRunning) {
            System.out.println("Player " + currentPlayer + ", enter a position (1-9): ");
            int position = scanner.nextInt();

            if (!isValidMove(position)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            placeMove(position);
            moveCount++;
            printBoard();

            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameRunning = false;
            } else if (moveCount == 9) {
                System.out.println("It's a draw!");
                gameRunning = false;
            } else {
                switchPlayer();
            }
        }

        scanner.close();
    }

    // Print the Tic Tac Toe board
    private static void printBoard() {
        System.out.println();
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if move is valid
    private static boolean isValidMove(int position) {
        if (position < 1 || position > 9) return false;

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        return board[row][col] != 'X' && board[row][col] != 'O';
    }

    // Place move on the board
    private static void placeMove(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        board[row][col] = currentPlayer;
    }

    // Switch player after each move
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Check if there is a winner
    private static boolean checkWin() {
        // Check rows, columns, and diagonals
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private static boolean checkRows() {
        for (char[] row : board) {
            if (row[0] == row[1] && row[1] == row[2]) return true;
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) return true;
        }
        return false;
    }

    private static boolean checkDiagonals() {
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }
}

