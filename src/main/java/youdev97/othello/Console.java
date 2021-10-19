package youdev97.othello;

import static youdev97.othello.model.Board.getLENGTH;
import static youdev97.othello.model.Board.getWIDTH;
import static youdev97.othello.model.ColorP.BLACK;
import static youdev97.othello.model.ColorP.WHITE;

import java.util.Scanner;

import youdev97.othello.model.Board;
import youdev97.othello.model.ColorP;
import youdev97.othello.model.Facade;
import youdev97.othello.model.Position;

/**
 * play the gam in console mode
 *
 * @author youdev97
 */
public class Console {


    /**
     * making display a given board of game
     *
     * @param board game board to display
     */
    public static void display(Facade board) {
        String boardline;
        System.out.print("  ");
        for (int i = 0; i < getLENGTH(); i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        for (int i = 0; i < getLENGTH(); i++) {
            boardline = " ";
            for (int j = 0; j < getWIDTH(); j++) {
                boardline += board.getPieceAt(new Position(i, j)) + " ";
            }
            System.out.println((i) + " " + boardline);
        }
    }
    
    public static void displayGame(Facade board) {
    	display(board);
    	System.out.println("Possible moves: " + board.moveList());
    	System.out.println("Current Player is " + board.getCurrentPlayer().getColor()
    			+ "\nAvailable commands: \n-show \n-score \n-play x y");
    }

    /**
     * play the game, allows to display the board get the score of each player
     * and place the pawns
     *
     * @param board board to play with
     */
    public static void play(Facade board) {
    	displayGame(board);
        Scanner clavier = new Scanner(System.in);
        while (board.isRunning()) {
            String str = clavier.nextLine();
            String[] separ = str.split(" ");
            while (!"show".equals(separ[0]) && !"score".equals(separ[0]) && !"play".equals(separ[0]) && !"wall".equals(separ[0])) {
                str = clavier.nextLine();
                separ = str.split(" ");
            }
            switch (separ[0]) {
                case "show":
                    displayGame(board);
                    break;
                case "score":
                    System.out.println("White number: " + board.cntColor(WHITE));
                    System.out.println("Black number: " + board.cntColor(BLACK));
                    break;
                case "play":
                    try {
                    	int x = Integer.parseInt(separ[1]);
                    	int y = Integer.parseInt(separ[2]);
                    	ColorP color = board.getCurrentPlayer().getColor();
                        board.place(new Position(x, y));
                        System.out.println(color + " Piece set at position " + x + ","+y);
                        displayGame(board);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrez des entiers svp!");
                    } catch (ArrayIndexOutOfBoundsException o) {
                        System.out.println("entrez deux entier svp!");
                    }
                case "wall":
                    board.placeWall(new Position(Integer.parseInt(separ[1]), Integer.parseInt(separ[2])));
                    break;
            }
        }
        clavier.close();
    }

    /**
     * create a board and play with
     *
     * @param arg
     */
    public static void main(String[] arg) {
        Facade b = new Board();
        play(b);

    }

}
