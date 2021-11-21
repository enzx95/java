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

    public static void initializeboard() {
        Playerturns = 0;
        numTotal = 0;
        gamestate = true;
        numTurns = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; i < 8; i++) {
               // if()
            }
        }
    }

}