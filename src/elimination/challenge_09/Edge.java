package elimination.challenge_09;

/**
 * <h3>Edge class</h3>
 * Used to encapsulate a Graph's edge data
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
 */

public class Edge implements Comparable {

    private final int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        return this.getWeight() - ((Edge) o).getWeight();
    }

    public int getSource() {
        return this.source;
    }

    public int getDestination() {
        return this.destination;
    }

    public int getWeight() {
        return this.weight;
    }
}
