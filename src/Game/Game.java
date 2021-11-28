package src.Game;

import src.Utilitaires.Utilitaires;

import java.util.ArrayList;
import java.util.HashMap;

import src.Model.Piece;



public class Game {
    static ArrayList<Piece>PiecesList=new ArrayList<Piece>();
    static String board[][] = new String[10][10];
    static HashMap<String, Piece> PiecesHash = new HashMap<String, Piece>();
    // static int numBoard[][] = new int[8][8];
    static boolean gamestate;
    //static int numTotal, numTurns, Playerturns;

    public static void main(String[] arg) {
        mainScreen();
        // askPiece();
    }

    public static void mainScreen() {
        boolean menuOn = true;
        do {
            System.out.println("Jeu de dames");
            System.out.println("1 - Jouer");
            System.out.println("2 - Quitter");

            int saisieMenu = Utilitaires.readInt();

            switch (saisieMenu) {
            case 1:
                //System.out.println("Playing");
                //Utilitaires.fillBoard(board);
                Utilitaires.drawBoard(board);
                Utilitaires.add_Pieces_To_List(PiecesList);
                Utilitaires.add_Pieces_To_Board(PiecesList, PiecesHash, board);
                Utilitaires.read_Board(board);
                break;
            case 2:
                System.out.println("Au revoir!");
                System.exit(0);
                break;
            }
        } while (menuOn);

    }

}