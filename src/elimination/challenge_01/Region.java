package elimination.challenge_01;

/**
 * <h3>Coordinate class</h3>
 * Used to encapsulate a Region data
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
     * Get the Region name
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the Region coordinate
     *
     * @return Coordinate
     */
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    /**
     * Calculate the Region distance from target
     * Time & space complexity: O(1)
     *
     * @param target Region
     * @return int
     */
    public int calculateDistanceFrom(Region target) {
        return (int) this.getCoordinate().distance(target.getCoordinate());
    }
}
