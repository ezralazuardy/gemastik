package elimination.challenge_04;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <h3>Pathfinder Class</h3>
 * Used for A* Search Algorithm implementation
 * <p>
 * Worst case time & space complexity:<code><b> O(b^d)</b></code><br/>
 * <b>b</b> equals to the branching factor of the maze<br/>
 * <b>d</b> equals to the depth of the goal node
 * </p>
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
 */
public class Pathfinder {

    private final PriorityQueue<Node> open, closed;
    private final Node start;
    private Node current;

    /**
     * Pathfinder constructor
     *
     * @param start Node
     */
    public Pathfinder(Node start) {
        this.open = new PriorityQueue<>();
        this.closed = new PriorityQueue<>();
        this.start = start;
    }

    /**
     * Find the path to target coordinate<br/>If there is no path, return an empty path list
     *
     * @param target Node
     * @return List(Node)
     */
    public List<Node> find(Node target) {

        // set the start node as current node
        this.current = start;

        // scan and add the optimal nearest neighbor node
        scanNeighbors();

        // find the end node
        while (!this.current.equals(target)) {

            // if then open set is empty, it means the end target isn't found
            // return an empty path list
            if (this.open.isEmpty()) return new ArrayList<>();

            // update current node with the first element of open set
            this.current = this.open.poll();

            // scan and add the optimal nearest neighbor node
            scanNeighbors();
        }

        // return the reconstructed path
        return reconstructPath(target);
    }

    /**
     * Reconstruct the path based on current node
     *
     * @param target Node
     * @return List(Node)
     */
    private List<Node> reconstructPath(Node target) {

        // verify if the current node is same as target node
        if (!this.current.equals(target))
            throw new IllegalStateException("There is no path found to the target coordinate!");

        // reconstruct the path
        final List<Node> path = new ArrayList<>();
        path.add(0, current);
        while (!current.equals(start)) {
            this.current = this.current.getParent();
            path.add(0, current);
        }

        // return reconstructed path
        return path;
    }

    /**
     * Scan the optimal nearest neighbors
     */
    private void scanNeighbors() {

        // add current node to closed set
        this.closed.add(this.current);

        // find neighbors through current node's edges
        // time & space complexity: O(n)
        for (Edge edge : this.current.getEdges()) {

            // initialize the new neighbor as node
            final Node neighbor = edge.getTargetNode();

            // if the new neighbor isn't added to open and closed set
            if (!this.open.contains(neighbor) && !this.closed.contains(neighbor)) {

                // set current node as the neighbor's parent
                neighbor.setParent(this.current);

                // increment the neighbor's g(n)
                neighbor.incrementG(edge.getWeight());

                // add the new neighbor to open set
                this.open.add(neighbor);

                // if the neighbor is already visited but it's g(n)
                // is less than current g(n), move neighbor to open set
            } else if (this.current.getG() + edge.getWeight() < neighbor.getG()) {

                // set current node as the neighbor's parent
                neighbor.setParent(this.current);

                // increment the neighbor's g(n)
                neighbor.incrementG(edge.getWeight());

                // add the new neighbor to open set
                this.open.add(neighbor);

                // make sure to move the neighbor to open set
                this.closed.remove(neighbor);
            }
        }
    }
}
