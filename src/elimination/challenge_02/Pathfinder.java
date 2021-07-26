package elimination.challenge_02;

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
    private final int[][] maze;
    private final boolean diagonal;
    private final Coordinate start;
    private Node current;

    /**
     * Pathfinder constructor
     *
     * @param maze  int[][]
     * @param start Coordinate
     */
    public Pathfinder(int[][] maze, Coordinate start) {
        this.open = new PriorityQueue<>();
        this.closed = new PriorityQueue<>();
        this.maze = maze;
        this.start = start;
        this.diagonal = false;
    }

    /**
     * Find the path to target coordinate<br/>If there is no path, return an empty path list
     *
     * @param target Coordinate
     * @return List(Node)
     */
    public List<Node> find(Coordinate target) {

        // set the start node as current node
        this.current = new Node(null, start, 0, 0);

        // search and add the nearest neighbors to open set
        scanNeighbors(target);

        // find the end target
        while (!this.current.getCoordinate().equals(target)) {

            // if then open set is empty, it means the end target isn't found
            // return an empty path list
            if (this.open.isEmpty()) return new ArrayList<>();

            // set the first element of open set as current node
            this.current = this.open.poll();

            // search and add the nearest neighbors to open set
            scanNeighbors(target);
        }

        // return the reconstructed path
        return reconstructPath(target);
    }

    /**
     * Reconstruct the path to target node based on current node
     *
     * @param target Coordinate
     * @return List(Node)
     */
    private List<Node> reconstructPath(Coordinate target) {

        // verify if the current node is same as target node
        if (!this.current.getCoordinate().equals(target))
            throw new IllegalStateException("There is no path found to the target coordinate!");

        // if the end target is found, do reconstruct the path
        final List<Node> path = new ArrayList<>();
        path.add(0, this.current);
        while (!this.current.getCoordinate().equals(target)) {
            this.current = this.current.getParent();
            path.add(0, this.current);
        }

        // return the reconstructed path
        return path;
    }

    /**
     * Scan the optimal nearest neighbors<br/>
     * Scan area:
     * <ul>
     * <li>(x - 1, y - 1) <sup>Euclidean</sup></li>
     * <li>(x - 1, y + 1) <sup>Euclidean</sup></li>
     * <li>(x + 1, y - 1) <sup>Euclidean</sup></li>
     * <li>(x + 1, y + 1) <sup>Euclidean</sup></li>
     * <li>(x - 1, y) <sup>Manhattan / Euclidean</sup></li>
     * <li>(x, y - 1) <sup>Manhattan / Euclidean</sup></li>
     * <li>(x, y + 1) <sup>Manhattan / Euclidean</sup></li>
     * <li>(x + 1, y) <sup>Manhattan / Euclidean</sup></li>
     * </ul>
     */
    private void scanNeighbors(final Coordinate target) {

        // add current node to closed set
        this.closed.add(this.current);

        // time & space complexity: O(x)
        for (int x = -1; x <= 1; x++) {

            // time & space complexity: O(x^2 - 1)
            for (int y = -1; y <= 1; y++) {

                // make sure that neighbor's x and y coordinate is different from current node
                if (x == 0 && y == 0) continue;

                final Coordinate neighborCoordinate = new Coordinate(this.current.getCoordinate().getX() + x, this.current.getCoordinate().getY() + y);

                // initialize the new neighbor as node
                final Node neighbor = new Node(
                        // set current node as a parent for the new neighbor node
                        this.current,
                        // set the neighbor coordinate based on the nested loop
                        neighborCoordinate,
                        // set the neighbor g(n) with current node g(n) value
                        this.current.getG(),
                        // set the neighbor h(n) by estimating Euclidean distance (if diagonal move is allowed)
                        // or Manhattan distance (if diagonal move isn't allowed)
                        this.current.getCoordinate().distance(neighborCoordinate, target, this.diagonal)
                );

                // ensure to only add neighbor based on Manhattan movement
                // if the diagonal movement is'nt allowed
                if (!this.diagonal
                        // and neighbor x coordinate isn't same as current x coordinate 
                        && neighbor.getCoordinate().getX() != current.getCoordinate().getX()
                        // and neighbor y coordinate is'nt same as current y coordinate
                        && neighbor.getCoordinate().getY() != current.getCoordinate().getY()
                ) continue;

                // add neighbor to open set
                // if neighbor x coordinate is 0 <= x < maximum_x
                if (neighbor.getCoordinate().getX() >= 0 && neighbor.getCoordinate().getX() < this.maze[0].length
                        // and if neighbor y coordinate is 0 <= y < maximum_y
                        && neighbor.getCoordinate().getY() >= 0 && neighbor.getCoordinate().getY() < this.maze.length
                        // and if path to neighbor is walkable, obstacle is identified by 0
                        && this.maze[neighbor.getCoordinate().getY()][neighbor.getCoordinate().getX()] != 0
                        // and if this new neighbor node isn't already added in open set
                        && !this.open.contains(neighbor)
                        // and if the new neighbor node isn't already added in closed set
                        && !this.closed.contains(neighbor)
                ) {

                    // set the neighbor g(n) by parent's g(n) + path price (default path price is 1) + 1
                    neighbor.incrementG(maze[neighbor.getCoordinate().getY()][neighbor.getCoordinate().getX()]);

                    // confirm add the neighbor to open set
                    this.open.add(neighbor);
                }
            }
        }
    }
}
