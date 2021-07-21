package elimination.challenge_01;

public class Region {

    private final String name;
    private final Coordinate coordinate;

    public Region(String name, int x, int y) {
        this.name = name;
        this.coordinate = new Coordinate(x, y);
    }

    public String getName() {
        return this.name;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    // calculate circle a and circle b based on x y coordinates
    // time & space complexity: O(1)
    public int calculateDistanceFrom(Region b) {
        return (int) this.getCoordinate().distance(b.getCoordinate());
    }
}
