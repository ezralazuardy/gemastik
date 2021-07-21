package elimination.challenge_02;

/**
 * <h3>Coordinate class</h3>
 * Used to encapsulate a coordinate location of en element
 */
public class Coordinate {

    private final int x;
    private final int y;

    /**
     * Coordinate constructor
     *
     * @param x int
     * @param y int
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate location
     *
     * @return int
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get the y coordinate location
     *
     * @return int
     */
    public int getY() {
        return this.y;
    }
}
