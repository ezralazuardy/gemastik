package elimination.challenge_04;

/**
 * <h3>Edge class</h3>
 * Used to encapsulate a Node's branch (Edge) data
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
 */
public class Edge implements Comparable {

    private final Node node;
    private final int weight;

    /**
     * Edge constructor
     *
     * @param node   Node
     * @param weight int
     */
    public Edge(Node node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    /**
     * Edge sorting comparator by <code>f(n)</code> value
     *
     * @param o Object
     * @return int
     */
    @Override
    public int compareTo(Object o) {
        return Integer.compare(((Edge) o).getWeight(), this.getWeight());
    }

    /**
     * Get the Node that this Edge's targeting to (neighbor Node)
     *
     * @return Node
     */
    public Node getTargetNode() {
        return this.node;
    }

    /**
     * Get Edge's weight
     *
     * @return int
     */
    public int getWeight() {
        return this.weight;
    }
}
