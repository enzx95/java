
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Checkers {

    private final static int SIZE = 8;
    private static char[][] board; // Stores the checkerboard, with chars 'r','b','_'
    private int redcheckers; // Number of red checkers on the board
    private int blackcheckers; // Number of black checkers on the board
    private char whosemove; // Either 'r' or 'b', for who's move it currently is.
    static String timeStamp = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(Calendar.getInstance().getTime());
    private static String player1;
    private static String player2;

    // Constructs default Checkers object, initializing board to starting
    // playing position.
    public Checkers() {

        board = new char[SIZE][SIZE];
        redcheckers = 12;
        blackcheckers = 12;
        whosemove = 'r';

        Scanner user_input = new Scanner(System.in);

        System.out.print("Comment s'appel le Joueur 1 ?");
        System.out.print("\n");
        player1 = user_input.next();
        System.out.print("Comment s'appel le Joueur 2 ?");
        System.out.print("\n");
        player2 = user_input.next();
        System.out.println("\n");

        // Initialize board with all the red and black checkers in starting
        // positions.
        int i, j;
        for (i = 0; i < SIZE; i++)
            for (j = 0; j < SIZE; j++)
                board[i][j] = '_';

        for (i = 1; i < SIZE; i += 2) {
            board[i][1] = 'r';
            board[i][5] = 'b';
            board[i][7] = 'b';
        }
        for (i = 0; i < SIZE; i += 2) {
            board[i][0] = 'r';
            board[i][2] = 'r';
            board[i][6] = 'b';
        }
    }

    // Print out the checkerboard, by looping through all board positions in
    // appropriate order.
    public void printBoard() {
        int i, j;
        System.out.println("  1 2 3 4 5 6 7 8 ");
        for (i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (j = 0; j < SIZE; j++) {
                System.out.print(board[j][i] + " ");
            }
            System.out.println();
        }
        // System.out.println("y");
    }

    public static void lastBoard() {
        int i, j;
        //System.out.println("\n");
        WriteToFile("  1 2 3 4 5 6 7 8  ", timeStamp);
        WriteToFile("\n", timeStamp);
        for (i = 0; i < SIZE; i++) {
            WriteToFile((i + 1) + " ", timeStamp);
            for (j = 0; j < SIZE; j++) {
                WriteToFile(board[j][i] + " ", timeStamp);
            }
            WriteToFile("\n", timeStamp);
        }
        WriteToFile(" ", timeStamp);
    }

    // This method executes one move.
    public void getNextMove() throws IOException {

        Scanner stdin = new Scanner(System.in);
        System.out.println("\n");
        if (whosemove == 'r')
            System.out.println("C'est le tour de " + player1 + " (Blanc)");
        else
            System.out.println("C'est le tour de " + player2 + " (Noir)");

        boolean moved = false;
        // Loops until legal move is entered.
        while (!moved) {
            // Reads in square to move from and to.
            System.out.println("Saisissez la case à partir de laquelle vous souhaitez vous déplacer.");
            System.out.print("Entrez un nombre à deux chiffres. (par exemple, si vous vous déplacez de");
            System.out.println(" x=1,y=3, entrez 13)");
            int movefrom = stdin.nextInt();

            System.out.print("Saisissez la case vers laquelle vous souhaitez vous déplacer, ");
            System.out.println("en utilisant la même convention.");
            int moveto = stdin.nextInt();

            // Checks to see if move is valid, if so, executes it.
            if (validMove(movefrom, moveto)) {
                executeMove(movefrom, moveto);
                moved = true;
            } else
                System.out.println("C'est un mouvement invalide, essayez encore.");
        }

        // Update whosemove it is.
        if (whosemove == 'r')
            whosemove = 'b';
        else
            whosemove = 'r';
    }

    // Checks if a move is valid.
    public boolean validMove(int movefrom, int moveto) {

        // Gets array indeces corresponding to the move, from parameters.
        int xfrom = movefrom / 10 - 1;
        int yfrom = movefrom % 10 - 1;
        int xto = moveto / 10 - 1;
        int yto = moveto % 10 - 1;

        // Check if indeces in range, if not, return false.
        if (xfrom < 0 || xfrom > 7 || yfrom < 0 || yfrom > 7 ||
                xto < 0 || xto > 7 || yto < 0 || yto > 7)
            return false;

        // Check to see you are moving your piece to a blank square.
        else if (board[xfrom][yfrom] == whosemove && board[xto][yto] == '_') {

            // Checks case of simple move
            if (Math.abs(xfrom - xto) == 1) {
                if ((whosemove == 'r') && (yto - yfrom == 1))
                    return true;
                else if ((whosemove == 'b') && (yto - yfrom == -1))
                    return true;
            }

            // Checks case of a jump
            else if (Math.abs(xfrom - xto) == 2) {
                if (whosemove == 'r' && (yto - yfrom == 2) &&
                        board[(xfrom + xto) / 2][(yfrom + yto) / 2] == 'b')
                    return true;
                else if (whosemove == 'b' && (yto - yfrom == -2) &&
                        board[(xfrom + xto) / 2][(yfrom + yto) / 2] == 'r')
                    return true;
            }
        }
        // If move is neither a simple one or a jump, it is not legal.
        return false;
    }

    // Executes a move.
    public void executeMove(int movefrom, int moveto) {
        // Gets array indeces corresponding to the move, from parameters.
        int xfrom = movefrom / 10 - 1;
        int yfrom = movefrom % 10 - 1;
        int xto = moveto / 10 - 1;
        int yto = moveto % 10 - 1;

        // Change appropriate board elements and decrement redcheckers or
        // blackcheckers if necessary.
        board[xfrom][yfrom] = '_';
        board[xto][yto] = whosemove;
        if (Math.abs(xto - xfrom) == 2) {
            board[(xfrom + xto) / 2][(yfrom + yto) / 2] = '_';
            if (whosemove == 'r')
                redcheckers--;
            else
                blackcheckers--;
        }
        String move = movefrom + " to " + moveto;
        WriteToFile(move, timeStamp);
        WriteToFile("\n", timeStamp);
    }

    // Checks to see if game is over based on number of checkers left.
    public boolean gameOver() {
        return (redcheckers == 0 || blackcheckers == 0);

        // return true;
    }

    // Returns color of the winner.
    public String winnerIs() {
        if (blackcheckers == 0)
            return player1;
        else
            return player2;
    }

    public static void main(String args[]) throws IOException {

        // Setup and print out checker board.
        Checkers game = new Checkers();
        game.printBoard();

        // Loop until game is over.
        while (!game.gameOver()) {
            // Execute a move and print the board out afterwards.
            game.getNextMove();
            game.printBoard();
        }
        // Announce winner.
        WriteToFile("\n", timeStamp);
        lastBoard();
        System.out.println("Le gagnant est " + game.winnerIs());
        WriteToFile("\n", timeStamp);
        WriteToFile("\n", timeStamp);
        WriteToFile("\n" + player1 + " contre " + player2 + "\nGagnant = " + game.winnerIs() + "\n", "Historique");
    }

    public static void WriteToFile(String line, String name) {
        try {
            FileWriter myWriter = new FileWriter(name + ".txt", true);
            myWriter.append(line);
            myWriter.close();
            // System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
