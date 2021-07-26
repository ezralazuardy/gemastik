package elimination.challenge_04;

import java.util.PriorityQueue;

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

    private final PriorityQueue<Edge> edges;
    private final int id;
    private final double h;
    private double g;
    private Node parent;

    /**
     * Node constructor
     *
     * @param id int
     * @param h  int
     */
    public Node(int id, int h) {
        this.edges = new PriorityQueue<>();
        this.id = id;
        this.h = h;
        this.g = 0;
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
        return this.getId() == ((Node) o).getId();
    }

    /**
     * Add a new branch (Edge) to Node
     *
     * @param neighbor Node
     * @param weight   int
     */
    public void addBranch(Node neighbor, int weight) {
        this.edges.add(new Edge(neighbor, weight));
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
     * Set a new parrent for Node
     *
     * @param parent Node
     */
    public void setParent(Node parent) {
        this.parent = parent;
        this.g = this.parent.getG();
    }

    /**
     * Get Node's edges
     *
     * @return PriorityQueue(Edge)
     */
    public PriorityQueue<Edge> getEdges() {
        return this.edges;
    }

    /**
     * Get Node's id
     *
     * @return int
     */
    public int getId() {
        return this.id;
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
        this.g += +pathPrice;
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
