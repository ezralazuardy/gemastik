package elimination.challenge_01;

/**
 * <h3>Coordinate class</h3>
 * Used to encapsulate a Region data
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
 */
public class Region {

    private final String name;
    private final Coordinate coordinate;

    /**
     * Region constructor
     *
     * @param name String
     * @param x    int
     * @param y    int
     */
    public Region(String name, int x, int y) {
        this.name = name;
        this.coordinate = new Coordinate(x, y);
    }

    /**
     * Get Region's name
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get Region's coordinate
     *
     * @return Coordinate
     */
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    /**
     * Calculate Region distance from target<br/>
     * with time & space complexity: O(1)
     *
     * @param target Region
     * @return int
     */
    public int calculateDistanceFrom(Region target) {
        return (int) this.getCoordinate().distance(target.getCoordinate());
    }
}
