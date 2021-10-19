package youdev97.othello.model;

import java.util.List;

/**
 *
 * @author youdev97
 */
public interface Facade {

    public boolean isRunning();

    public int cntColor(ColorP clr);

    public Piece getCurrentPlayer();

    public List<Position> moveList();

    public void place(Position pos);

    public void placeWall(Position pos);

    public Piece getPieceAt(Position pos);
    
    public void nextPlayer();
    
    public void notifyObservers();
    
    public void restart();
    
    public Strategy getStrategy();
    
    public List<Position> getPosSwitchedB();
    
    public List<Position> getPosSwitchedW();
    
}
