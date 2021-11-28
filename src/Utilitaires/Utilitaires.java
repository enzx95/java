package src.Utilitaires;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import src.Model.Piece;

public class Utilitaires {
    public static int readInt() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        try {
            i = sc.nextInt();
        } catch (Exception e) {
        }
        return i;
    }

    public static void fillBoard(String[][] board) {

        for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 8; ++j)
                board[i][j] = " ";
        for (int i = 0; i < 3; ++i) {
            if (i % 2 == 0) {
                for (int j = 1; j < 8; j += 2)

                    board[i][j] = "X";
            } else {
                for (int j = 0; j < 8; j += 2)
                    board[i][j] = "X";

            }
        }
        for (int i = 7; i > 4; --i) {
            if (i % 2 == 0) {
                for (int j = 1; j < 8; j += 2)
                    board[i][j] = "O";

            } else {
                for (int j = 0; j < 8; j += 2)
                    board[i][j] = "O";

            }
        }
        printBoard(board);
    }

    public static void printBoard(String[][] board) {
        for (int i = 1; i < 9; ++i) {
            System.out.print("   " + i);
        }
        System.out.print("\n  ");
        for (int i = 0; i < 8; ++i)
            System.out.print("+---");
        System.out.print("+\n");
        for (int i = 0; i < 8; ++i) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; ++j) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.print("|\n  ");
            for (int i2 = 0; i2 < 8; ++i2)
                System.out.print("+---");
            System.out.print("+\n");
        }

    }

    private static int[] askPiece() {
        boolean intErr = true;
        int colonne = 0;
        int ligne = 0;
        System.out.println("Quel pion souhaitez vous déplacer?");
        do {
            try {
                colonne = Integer.parseInt(System.console().readLine("Colonne:  "));
                // do stuff
                // System.out.println(colonne);
                intErr = false;
            } catch (NumberFormatException e) {
                // User did not enter a number
                System.out.println("Veuillez saisir un entier compris entre 1 et 8.");
                intErr = true;
            }
        } while (intErr);
        do {
            try {
                ligne = Integer.parseInt(System.console().readLine("Ligne:  "));
                // do stuff
                // System.out.println(ligne);
                intErr = false;
            } catch (NumberFormatException e) {
                // User did not enter a number
                System.out.println("Veuillez saisir un entier compris entre 1 et 8.");
                intErr = true;
            }
        } while (intErr);

        return new int[] { colonne, ligne };
    }

    public static void add_Pieces_To_List(ArrayList<Piece> PiecesList) {
        int id = 1;
        int size = 10;
        for (int line = 1; line < (size / 2) - 1; line++) {
            for (int column = 1; column < size - 2; column = column + 2) {
                if (line % 2 != 0) {
                    PiecesList.add(new Piece("B" + String.valueOf(id), "Black", id, line, column, false));
                    PiecesList.add(
                            new Piece("W" + String.valueOf(id), "White", id, line + (size / 2), column + 1, false));
                } else {
                    PiecesList.add(new Piece("B" + String.valueOf(id), "Black", id, line, column + 1, false));
                    PiecesList.add(new Piece("W" + String.valueOf(id), "White", id, line + (size / 2), column, false));
                }
                id++;
            }

        }

    }

    public static void add_Pieces_To_Board(ArrayList<Piece> alP, HashMap<String, Piece> hmP, String[][] board) {
        for (Piece P : alP) {
            board[P.getY()][P.getX()] = P.getName();
            hmP.put(P.getName(), P);
        }
    }

    public static void read_Board(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("	" + board[i][j]);
            }
            System.out.println("\n\n");
        }
    }

    public static void drawBoard(String[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                board[0][0] = " ";
                board[0][board[i].length - 1] = " ";
                board[board.length - 1][0] = " ";
                board[board.length - 1][board[i].length - 1] = " ";
            }

        }
        boardBoarders(board);
    }

    public static void boardBoarders(String[][] board) {
        String[] letters = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
        String[] numbers = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
        ;
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                board[0][j] = letters[j - 1];
                board[board.length - 1][j] = " ";
                board[i][0] = numbers[i - 1];
                board[i][board[i].length - 1] =" ";
                board[i][j] = ".";
            }
        }
    }

}
