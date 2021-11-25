import java.util.Scanner;

public class Jeu {
    static char board[][] = new char[8][8];
    static int numBoard[][] = new int[8][8];
    static boolean gamestate;
    static int numTotal, numTurns, Playerturns;

    public static void main(String[] arg) {
        mainScreen();
    }

    public static void mainScreen() {
        boolean menuOn = true;
        do {
            System.out.println("Jeu de dames");
            System.out.println("1 - Jouer");
            System.out.println("2 - Quitter");

            int saisieMenu = readInt();

            switch (saisieMenu) {
            case 1:
                System.out.println("Playing");
                fillBoard();
                break;
            case 2:
                System.exit(0);
                break;
            }
        } while (menuOn);

    }

    public static int readInt() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        try {
            i = sc.nextInt();
        } catch (Exception e) {
        }
        return i;
    }

    // public static void initializeboard() {
    // Playerturns = 0;
    // numTotal = 0;
    // gamestate = true;
    // numTurns = 0;
    // for (int i = 0; i < 8; i++) {
    // for (int j = 0; i < 8; i++) {
    // // if()
    // }
    // }
    // }

    private static void fillBoard() {

        for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 8; ++j)
                board[i][j] = ' ';
        for (int i = 0; i < 3; ++i) {
            if (i % 2 == 0) {
                for (int j = 1; j < 8; j += 2)
                    board[i][j] = 'a';
            } else {
                for (int j = 0; j < 8; j += 2)
                    board[i][j] = 'a';
            }
        }
        for (int i = 7; i > 4; --i) {
            if (i % 2 == 0) {
                for (int j = 1; j < 8; j += 2)
                    board[i][j] = 'b';
            } else {
                for (int j = 0; j < 8; j += 2)
                    board[i][j] = 'b';
            }
        }
        printBoard();
    }

    private static void printBoard() {
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

}