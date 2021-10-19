package youdev97.othello.model;

/**
 * Different direction to check
 *
 * @author youdev97
 */
public enum Direction {

    /**
     * OUEST
     */
    O(0, -1),
    /**
     * NORTH OUEST
     */
    NO(-1, -1),
    /**
     * NORTH
     */
    N(-1, 0),
    /**
     * NORTH EST
     */
    NE(-1, +1),
    /**
     * EST
     */
    E(0, +1),
    /**
     * SOUTH EST
     */
    SE(+1, +1),
    /**
     * SOUTH
     */
    S(+1, 0),
    /**
     * SOUTH OUEST
     */
    SO(+1, -1);

    private final int x;
    private final int y;

    private Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * getter of x (x,y)
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * getter of y (x,y)
     *
     * @return y
     */
    public int getY() {
        return y;
    }
}
