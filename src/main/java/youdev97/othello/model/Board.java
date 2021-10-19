package youdev97.othello.model;

import static youdev97.othello.model.ColorP.*;

import java.util.ArrayList;
import java.util.List;

/**
 * the board and actions of the game
 *
 * @author youdev97
 */
public class Board implements Facade, Observable {

    private static final int LENGTH = 8;
    private static final int WIDTH = 8;
    private Piece tab[][];
    private Piece currentPlayer;
    private boolean isRunning;
    private List<Observer> observers;
    private Strategy strategy;
    private List<Position> posSwitchedB;
    private List<Position> posSwitchedW;

    public List<Position> getPosSwitchedB() {
        return posSwitchedB;
    }

    public List<Position> getPosSwitchedW() {
        return posSwitchedW;
    }

    /**
     * constructor that initialize a board with default width and height placing
     * fake or invisible pion to make the box of the board empty placing 4 pawn
     * it's the default state to play the first player to play is the owner of
     * black color
     */
    public Board() {       
        this.strategy = new RandomStrat();
        observers = new ArrayList<>();
        restart();
    }

    @Override
    public void restart() {
        this.posSwitchedB = new ArrayList<>();
        this.posSwitchedW = new ArrayList<>();
        tab = new Piece[LENGTH][WIDTH];
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                tab[i][j] = new Piece(EMPTY);
            }
        }
        tab[LENGTH / 2 - 1][WIDTH / 2 - 1] = new Piece(WHITE);
        tab[LENGTH / 2 - 1][WIDTH / 2] = new Piece(BLACK);
        tab[LENGTH / 2][WIDTH / 2 - 1] = new Piece(BLACK);
        tab[LENGTH / 2][WIDTH / 2] = new Piece(WHITE);
        this.isRunning = true;
        this.currentPlayer = new Piece(BLACK);
        notifyObservers();
    }

    /**
     * getter of a pawn in a position of tab
     *
     * @param pos position to check
     * @return the pawn
     */
    @Override
    public Piece getPieceAt(Position pos) {
        return tab[pos.getX()][pos.getY()];
    }

    /**
     * place a pawn in the given position
     *
     * @param pos
     * @param pion
     */
    public void setPieceAt(Position pos, Piece pion) {
        tab[pos.getX()][pos.getY()] = pion;
    }

    /**
     * get width of the board
     *
     * @return integer size
     */
    public static int getLENGTH() {
        return LENGTH;
    }

    /**
     * get height of the board
     *
     * @return integer size
     */
    public static int getWIDTH() {
        return WIDTH;
    }

    /**
     * get the current player to play
     *
     * @return pawn
     */
    @Override
    public Piece getCurrentPlayer() {
        return this.currentPlayer;
    }

    Piece getAdvPlayer() {
        return (currentPlayer.getColor() == BLACK)
                ? new Piece(WHITE) : new Piece(BLACK);
    }

    @Override
    public Strategy getStrategy() {
        return strategy;
    }

    /**
     * allows to switch to the next player
     */
    @Override
    public void nextPlayer() {
        currentPlayer = (currentPlayer.getColor() == BLACK)
                ? new Piece(WHITE) : new Piece(BLACK);
        //notifyObservers();
    }

    /**
     * count number of pawn in the board for given color
     *
     * @param clr color to count
     * @return integer number of pawns
     */
    @Override
    public int cntColor(ColorP clr) {
        int count = 0;
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (tab[i][j].getColor() == clr) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * check if a position is inside the board
     *
     * @param p position to check
     * @return true if it's in
     */
    public boolean isInside(Position p) {
        boolean inside = false;
        if (p.getX() >= 0 && p.getX() < LENGTH && p.getY() >= 0
                && p.getY() < WIDTH) {
            inside = true;
        }
        return inside;
    }

    /**
     * check if still valid position for current player if not check again for
     * the next player if the second player don't have valid position too end of
     * the game
     *
     * @return false if the two players can't play
     */
    @Override
    public boolean isRunning() {
        List<Position> l = moveList();
        if (l.isEmpty()) {
            nextPlayer();
            l = moveList();
            if (l.isEmpty()) {
                isRunning = false;
            }
        }
        return isRunning;
    }

    /**
     * list of valid position to play for the current player
     *
     * @return list of position
     */
    @Override
    public List<Position> moveList() {
        List<Position> moveList = new ArrayList<>();
        Position pos;
        for (int x = 0; x < LENGTH; x++) {
            for (int y = 0; y < WIDTH; y++) {
                pos = new Position(x, y);
                if (legalMove(pos)) {
                    moveList.add(pos);
                }
            }
        }
        return moveList;
    }

    /**
     * is it legal due to the game rules to place a pawn on the given position
     *
     * @param pos position to check and to place a pawn
     * @return true if position is inside and correctly taking in sandwich in at
     * least one direction pawn of the opponent
     */
    public boolean legalMove(Position pos) {
        boolean legal = false;
        if (getPieceAt(pos).getColor() != EMPTY) {  //check si la position est deja occupé
            return false;
        }
        for (Direction d : Direction.values()) {  //check si legal
            if (getNbrSwitches(pos, d) > 0) {
                legal = true;
            }
        }
        return legal;
    }

    /**
     * get from a given position and direction how many pawns we have to switch
     * the color
     *
     * @param pos given position (where we have placed a new pawn)
     * @param d direction to check
     * @return number of opponent pawn to switch in this direction
     */
    public int getNbrSwitches(Position pos, Direction d) {
        int toSwitch = 0;
        Position tmp = new Position(pos);
        tmp = new Position(tmp.getX() + d.getX(), tmp.getY() + d.getY());
        while (isInside(tmp) && getPieceAt(tmp).getColor() == getAdvPlayer().getColor()) {
            tmp = new Position(tmp.getX() + d.getX(), tmp.getY() + d.getY());
            toSwitch++;
        }
        if (isInside(tmp) && getPieceAt(tmp).getColor() == currentPlayer.getColor()) {
            return toSwitch;
        } else {
            return 0;
        }
    }

    /**
     * switch the correct number of opponent pawns in a given direction
     *
     * @param pos position from
     * @param d direction to follow
     * @param retourner number of time we go on that direction
     * @return a list of the switched piece
     */
    void switchPiece(Position pos, Direction d, int retourner) {
        Position tmp = new Position(pos);
        tmp = new Position(tmp.getX() + d.getX(), tmp.getY() + d.getY());
        for (int i = 0; i < retourner; i++) {
            setPieceAt(tmp, currentPlayer);
            if (currentPlayer.getColor() == BLACK) {
                posSwitchedB.add(tmp);
            } else if (currentPlayer.getColor() == WHITE) {
                posSwitchedW.add(tmp);
            }
            tmp = new Position(tmp.getX() + d.getX(), tmp.getY() + d.getY());
        }
    }

    /**
     * allows to place a pawn
     *
     * @param pos desired position to place
     */
    @Override
    public void place(Position pos) {
        List<Position> possibleMove = new ArrayList<>(moveList());
        int switched;
        if (isRunning && possibleMove.contains(pos)) {
            setPieceAt(pos, currentPlayer); //placement du pion
            //switch des pions
            for (Direction d : Direction.values()) {
                switched = getNbrSwitches(pos, d);
                if (switched > 0) {
                    switchPiece(pos, d, switched);
                }
            }
            nextPlayer();
            notifyObservers();        
        }
    }

    /**
     * place a wall
     *
     * @param pos desired position
     */
    @Override
    public void placeWall(Position pos) {
        if (isRunning && isInside(pos)) {
            if (getPieceAt(pos).getColor() == EMPTY) {
                setPieceAt(pos, new Piece(WALL));
                nextPlayer();
            } else if(getPieceAt(pos).getColor() == WALL) {
                setPieceAt(pos, new Piece(EMPTY));
                nextPlayer();
            }
        notifyObservers();
        }    
    }

    @Override
    public void registerObserver(Observer obs) {
        if (!observers.contains(obs)) {
            observers.add(obs);
        }
    }

    @Override
    public void removeObserver(Observer obs) {
        if (observers.contains(obs)) {
            observers.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }

}
