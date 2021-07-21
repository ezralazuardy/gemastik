package elimination.challenge_02;

public class Node implements Comparable {

    public Node parent;
    public Coordinate coordinate;
    public double g;
    public double h;

    public Node(Node parent, Coordinate coordinate, double g, double h) {
        this.parent = parent;
        this.coordinate = coordinate;
        this.g = g;
        this.h = h;
    }

    @Override
    public int compareTo(Object o) {
        Node other = (Node) o;
        return (int) ((this.g + this.h) - (other.g + other.h));
    }
}
