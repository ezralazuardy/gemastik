package elimination.challenge_02;

/**
 * <h3>Coordinate class</h3>
 * Used to encapsulate a coordinate location of en element
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
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
     * Coordinate identity comparator by <code>x</code> and <code>y</code> coorinate value
     *
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate)) return false;
        return this.getX() == ((Coordinate) o).getX() && this.getY() == ((Coordinate) o).getY();
    }

    /**
     * Get <code>x</code> coordinate location
     *
     * @return int
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get <code>y</code> coordinate location
     *
     * @return int
     */
    public int getY() {
        return this.y;
    }

    /**
     * Calculate distance between current and target coordinate.
     * If diagonal search is allowed, calculate the Euclidean distance.
     * If diagonal search isn't allowed, calculate the Manhattan distance.
     *
     * @param target Coordinate
     * @return double
     */
    public double distance(Coordinate target, Coordinate end, boolean diagonal) {

        // if diagonal movement is allowed, calculate the Euclidean distance
        if (diagonal)
            return Math.hypot(this.getX() + target.getX() - end.getX(), this.getY() + target.getY() - end.getY());

        // if diagonal movement isn't allowed, calculate the Manhattan distance
        return Math.abs(this.getX() + target.getX() - end.getX()) + Math.abs(this.getY() + target.getY() - end.getY());
    }
}
