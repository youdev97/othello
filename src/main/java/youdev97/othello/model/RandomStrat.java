/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youdev97.othello.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Strategy of IA
 * @author youdev97
 */
public class RandomStrat implements Strategy {

    /**
     * Ia play a random position from the possible moves
     * @param b the board
     */
    @Override
    public void iaPlay(Facade b) { 
        List<Position> possibleMove = new ArrayList<>(b.moveList());
        int randomNum = ThreadLocalRandom.current().nextInt(0, possibleMove.size());
        Position pos = possibleMove.get(randomNum);
        b.place(pos);
    }

}
