package youdev97.othello.model;

import java.util.Objects;

/**
 * Pawn, have 2 sides one black and one white
 *
 * @author youdev97
 */
public class Piece {

    private final ColorP color;

    /**
     * constructor
     *
     * @param clr color side of pawn
     */
    public Piece(ColorP clr) {
        this.color = clr;
    }

    /**
     * get the current color of a the pawn
     *
     * @return
     */
    public ColorP getColor() {
        return color;
    }

    @Override
    public String toString() {
        switch (getColor()) {
            case WHITE:
                return "W";
            case BLACK:
                return "B";
            case WALL:
                return "W";
            default:
                return " ";
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piece other = (Piece) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }


}
