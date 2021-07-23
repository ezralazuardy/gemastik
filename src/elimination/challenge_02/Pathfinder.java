package elimination.challenge_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    private final List<Node> open, closed, path;
    private final int[][] maze;
    private final boolean diagonal;
    private final Coordinate start;
    private Coordinate end;
    private Node current;

    /**
     * Pathdiner constructor
     *
     * @param maze  int[][]
     * @param start Coordinate
     */
    public Pathfinder(int[][] maze, Coordinate start) {
        this.open = new ArrayList<>();
        this.closed = new ArrayList<>();
        this.path = new ArrayList<>();
        this.current = new Node(null, start, 0, 0);
        this.maze = maze;
        this.start = start;
        this.diagonal = false;
    }

    /**
     * Finds path to target or returns null
     *
     * @param target Coordinate
     * @return List(Node)
     */
    public List<Node> find(Coordinate target) {

        // mark the given target coordinate as an end target
        this.end = target;

        // search and add the nearest neighbors to open set
        addNeighborsToOpenList();

        // find the end target
        while (this.current.getCoordinate().getX() != this.end.getX() || this.current.getCoordinate().getY() != this.end.getY()) {

            // if then open set is empty, it means the end target isn't found
            // return an empty path
            if (this.open.isEmpty()) return this.path;

            // set the first element of open set as current node
            this.current = this.open.get(0);

            // remove the first element in open set
            // because it have been used as current node
            this.open.remove(0);

            // search and add the nearest neighbors to open set
            addNeighborsToOpenList();
        }

        // if the end target is found, do reconstruct the path
        this.path.add(0, this.current);
        while (this.current.getCoordinate().getX() != this.start.getX() || this.current.getCoordinate().getY() != this.start.getY()) {
            this.current = this.current.getParent();
            this.path.add(0, this.current);
        }

        // return the reconstructed path
        return this.path;
    }

    /**
     * Looks in a given list for a neighbors node
     *
     * @param nodes  List(Node)
     * @param target Node
     * @return boolean
     */
    private static boolean findNodeInList(List<Node> nodes, Node target) {

        // return true if the target node is available in the given node list
        return nodes.stream().anyMatch(n ->
                n.getCoordinate().getX() == target.getCoordinate().getX() && n.getCoordinate().getY() == target.getCoordinate().getY());
    }

    /**
     * Calculate distance between current and end target.
     * If diagonal search is allowed, calculate the Euclidean distance.
     * If diagonal search isn't allowed, calculate the Manhattan distance.
     *
     * @param target Coordinate
     * @return double
     */
    private double distance(Coordinate target) {
        if (this.diagonal)
            return Math.hypot(this.current.getCoordinate().getX() + target.getX() - this.end.getX(), this.current.getCoordinate().getY() + target.getY() - this.end.getY());
        return Math.abs(this.current.getCoordinate().getX() + target.getX() - this.end.getX()) + Math.abs(this.current.getCoordinate().getY() + target.getY() - this.end.getY());
    }

    /**
     * Search and add nearest neighbors to open list<br/>
     * Scan area:
     * <ul>
     * <li>(x - 1, y - 1) <sup>Euclidean</sup></li>
     * <li>(x - 1, y + 1) <sup>Euclidean</sup></li>
     * <li>(x + 1, y - 1) <sup>Euclidean</sup></li>
     * <li>(x + 1, y + 1) <sup>Euclidean</sup></li>
     * <li>(x - 1, y) <sup>Manhattan</sup></li>
     * <li>(x, y - 1) <sup>Manhattan</sup></li>
     * <li>(x, y + 1) <sup>Manhattan</sup></li>
     * <li>(x + 1, y) <sup>Manhattan</sup></li>
     * </ul>
     */
    private void addNeighborsToOpenList() {

        // add current node to closed set
        this.closed.add(this.current);

        // initialize state to check if the open set is updated
        boolean updatedOpenSet = false;

        // time & space complexity: O(x)
        for (int x = -1; x <= 1; x++) {

            // time & space complexity: O(x^2)
            for (int y = -1; y <= 1; y++) {

                // initialize the new neighbor as node
                final Node neighbor = new Node(
                        // set current node as a parent for the new neighbor node
                        this.current,
                        // set the neighbor coordinate based on the nested loop
                        new Coordinate(this.current.getCoordinate().getX() + x, this.current.getCoordinate().getY() + y),
                        // set the neighbor g(n) with current node g(n) value
                        this.current.getG(),
                        // set the neighbor h(n) by estimating Euclidean distance (if diagonal move is allowed)
                        // or Manhattan distance (if diagonal move isn't allowed)
                        this.distance(new Coordinate(this.current.getCoordinate().getX() + x, this.current.getCoordinate().getY() + y))
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
                // if the neighbor coordinate x or y isn't the same as current node
                if ((neighbor.getCoordinate().getX() != current.getCoordinate().getX() || neighbor.getCoordinate().getY() != current.getCoordinate().getY())
                        // and if neighbor x coordinate is 0 <= x < maximum_x
                        && neighbor.getCoordinate().getX() >= 0 && neighbor.getCoordinate().getX() < this.maze[0].length
                        // and if neighbor y coordinate is 0 <= y < maximum_y
                        && neighbor.getCoordinate().getY() >= 0 && neighbor.getCoordinate().getY() < this.maze.length
                        // and if path to neighbor is walkable, obstacle is identified by 0
                        && this.maze[neighbor.getCoordinate().getY()][neighbor.getCoordinate().getX()] != 0
                        // and if this new neighbor node isn't already added in open set
                        && !findNodeInList(this.open, neighbor)
                        // and if the new neighbor node isn't already added in closed set
                        && !findNodeInList(this.closed, neighbor)
                ) {

                    // set the neighbor g(n) by parent's g(n) + path price (default path price is 1) + 1
                    neighbor.incrementG(maze[neighbor.getCoordinate().getY()][neighbor.getCoordinate().getX()]);

                    // confirm add the neighbor to open set
                    this.open.add(neighbor);

                    // mark the updated open set state to true
                    updatedOpenSet = true;
                }
            }
        }

        // if the open set is updated, sort it by ascending order
        if (updatedOpenSet) Collections.sort(this.open);
    }
}
