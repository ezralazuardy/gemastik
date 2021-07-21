package elimination.challenge_01;

public class Region {

    private final String name;
    private final int x;
    private final int y;

    public Region(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // calculate circle a and circle b based on x y coordinates
    // distance: sqrt((x_a - x_b)^2 + (y_a - y_b)^2)
    // time & space complexity: O(1)
    public int calculateDistanceFrom(Region b) {
        return (int) Math.floor(Math.sqrt(Math.pow(this.getX() - b.getX(), 2) + Math.pow(this.getY() - b.getY(), 2)));
    }
}
