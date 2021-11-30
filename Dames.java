
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Dames {

    private static char[][] board;
    private int whitecheckers;
    private int blackcheckers;
    private char turn;
    static String timeStamp = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(Calendar.getInstance().getTime());
    private static String player1;
    private static String player2;

    public Dames() {

        board = new char[8][8];
        whitecheckers = 12;
        blackcheckers = 12;
        turn = 'w';

        Scanner user_input = new Scanner(System.in);

        System.out.print("Comment s'appel le Joueur 1 ?");
        System.out.print("\n");
        player1 = user_input.next();
        System.out.print("Comment s'appel le Joueur 2 ?");
        System.out.print("\n");
        player2 = user_input.next();
        System.out.println("\n");

        int i, j;
        for (i = 0; i < 8; i++)
            for (j = 0; j < 8; j++)
                board[i][j] = '.';

        for (i = 1; i < 8; i += 2) {
            board[i][1] = 'w';
            board[i][5] = 'b';
            board[i][7] = 'b';
        }
        for (i = 0; i < 8; i += 2) {
            board[i][0] = 'w';
            board[i][2] = 'w';
            board[i][6] = 'b';
        }
    }

    public void getNextMove() throws IOException {

        Scanner stdin = new Scanner(System.in);
        System.out.println("\n");
        if (turn == 'w')
            System.out.println("C'est le tour de " + player1 + " (Blanc)");
        else
            System.out.println("C'est le tour de " + player2 + " (Noir)");

        boolean moved = false;
        while (!moved) {
            System.out.println("Saisissez la case à partir de laquelle vous souhaitez vous déplacer.");
            System.out.print("Entrez un nombre à deux chiffres. (par exemple, si vous vous déplacez de");
            System.out.println(" x=1,y=3, entrez 13)");
            int movefrom = stdin.nextInt();

            System.out.print("Saisissez la case vers laquelle vous souhaitez vous déplacer, ");
            System.out.println("en utilisant la même convention.");
            int moveto = stdin.nextInt();

            if (validMove(movefrom, moveto)) {
                executeMove(movefrom, moveto);
                moved = true;
            } else
                System.out.println("C'est un mouvement invalide, essayez encore.");
        }

        if (turn == 'w')
            turn = 'b';
        else
            turn = 'w';
    }

    public boolean validMove(int movefrom, int moveto) {

        int xfrom = movefrom / 10 - 1;
        int yfrom = movefrom % 10 - 1;
        int xto = moveto / 10 - 1;
        int yto = moveto % 10 - 1;

        if (xfrom < 0 || xfrom > 7 || yfrom < 0 || yfrom > 7 || xto < 0 || xto > 7 || yto < 0 || yto > 7)
            return false;

        else if (board[xfrom][yfrom] == turn && board[xto][yto] == '.') {

            if (Math.abs(xfrom - xto) == 1) {
                if ((turn == 'w') && (yto - yfrom == 1))
                    return true;
                else if ((turn == 'b') && (yto - yfrom == -1))
                    return true;
            }

            else if (Math.abs(xfrom - xto) == 2) {
                if (turn == 'w' && (yto - yfrom == 2) && board[(xfrom + xto) / 2][(yfrom + yto) / 2] == 'b')
                    return true;
                else if (turn == 'b' && (yto - yfrom == -2) && board[(xfrom + xto) / 2][(yfrom + yto) / 2] == 'w')
                    return true;
            }
        }
        return false;
    }

    public void executeMove(int movefrom, int moveto) {
        int xfrom = movefrom / 10 - 1;
        int yfrom = movefrom % 10 - 1;
        int xto = moveto / 10 - 1;
        int yto = moveto % 10 - 1;

        board[xfrom][yfrom] = '.';
        board[xto][yto] = turn;
        if (Math.abs(xto - xfrom) == 2) {
            board[(xfrom + xto) / 2][(yfrom + yto) / 2] = '.';
            if (turn == 'w')
                whitecheckers--;
            else
                blackcheckers--;
        }
        String move = movefrom + " to " + moveto;
        WriteToFile(move, timeStamp);
        WriteToFile("\n", timeStamp);
    }

    public boolean gameOver() {
        return (whitecheckers == 0 || blackcheckers == 0);

    }

    public String getWinner() {
        if (blackcheckers == 0)
            return player1;
        else
            return player2;
    }

    public void printBoard() {
        int i, j;
        System.out.println("  1 2 3 4 5 6 7 8 ");
        for (i = 0; i < 8; i++) {
            System.out.print((i + 1) + " ");
            for (j = 0; j < 8; j++) {
                System.out.print(board[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void getLastBoard() {
        int i, j;
        WriteToFile("  1 2 3 4 5 6 7 8  ", timeStamp);
        WriteToFile("\n", timeStamp);
        for (i = 0; i < 8; i++) {
            WriteToFile((i + 1) + " ", timeStamp);
            for (j = 0; j < 8; j++) {
                WriteToFile(board[j][i] + " ", timeStamp);
            }
            WriteToFile("\n", timeStamp);
        }
        WriteToFile(" ", timeStamp);
    }

    public static void main(String args[]) throws IOException {

        Dames game = new Dames();
        game.printBoard();

        while (!game.gameOver()) {
            game.getNextMove();
            game.printBoard();
        }
        WriteToFile("\n", timeStamp);
        getLastBoard();
        System.out.println("Le gagnant est " + game.getWinner());
        WriteToFile("\n", timeStamp);
        WriteToFile("\n", timeStamp);
        WriteToFile("\n" + player1 + " contre " + player2 + "\nGagnant = " + game.getWinner() + "\n", "Historique");
    }

    public static void WriteToFile(String line, String name) {
        try {
            FileWriter myWriter = new FileWriter(name + ".txt", true);
            myWriter.append(line);
            myWriter.close();
            // System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
        }
    }
}
