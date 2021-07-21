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

    // calculate coordinates distance between this object and target
    // time & space complexity: O(1)
    public int calculateDistanceFrom(Region target) {
        return (int) this.getCoordinate().distance(target.getCoordinate());
    }
}
