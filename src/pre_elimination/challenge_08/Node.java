package pre_elimination.challenge_08;

/**
 * <h3>Node class</h3>
 * Used to encapsulate a Node data
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
 */
public class Node implements Comparable {

    private final Node parent;
    private final Coordinate coordinate;
    private final double h;
    private double g;

    /**
     * Node constructor
     *
     * @param parent     Node
     * @param coordinate Coordinate
     * @param g          double
     * @param h          double
     */
    public Node(Node parent, Coordinate coordinate, double g, double h) {
        this.parent = parent;
        this.coordinate = coordinate;
        this.g = g;
        this.h = h;
    }

    /**
     * Node sorting comparator by <code>f(n)</code> value
     *
     * @param o Object
     * @return int
     */
    @Override
    public int compareTo(Object o) {
        return Double.compare(this.getF(), ((Node) o).getF());
    }

    /**
     * Node identity comparator
     *
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) return false;
        return this.getCoordinate().getX() == ((Node) o).getCoordinate().getX() && this.getCoordinate().getY() == ((Node) o).getCoordinate().getY();
    }

    /**
     * Get Node's parent
     *
     * @return Node
     */
    public Node getParent() {
        return this.parent;
    }

    /**
     * Get Node's coordinate
     *
     * @return Coordinate
     */
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    /**
     * Get Node's <code>g(n)</code> value
     *
     * @return double
     */
    public double getG() {
        return this.g;
    }

    /**
     * Increment Node's <code>g(n)</code> value by the given path price
     *
     * @param pathPrice double
     */
    public void incrementG(double pathPrice) {
        this.g += this.parent.getG() + pathPrice;
    }

    /**
     * Get Node's <code>h(n)</code> value
     *
     * @return double
     */
    public double getH() {
        return this.h;
    }

    /**
     * Get Node's <code>f(n)</code> value
     *
     * @return double
     */
    public double getF() {
        return this.getG() + this.getH();
    }
}
