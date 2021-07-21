package elimination.challenge_02;

import java.util.*;

/**
 * <h3>Pathfinder Class</h3>
 * Used for A* Search Algorithm implementation
 * <p>
 * Worst case time & space complexity:<code><b> O(b^d)</b></code><br/>
 * <b>b</b> equals to the branching factor of the maze<br/>
 * <b>d</b> equals to the depth of the goal node
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
        this.diagonal = true;
    }

    /**
     * Finds path to target or returns null
     *
     * @param target Coordinate
     * @return List(Node)
     */
    public List<Node> find(Coordinate target) {
        this.end = target;
        this.closed.add(this.current);
        addNeighborsToOpenList();
        while (this.current.getCoordinate().getX() != this.end.getX() || this.current.getCoordinate().getY() != this.end.getY()) {
            if (this.open.isEmpty()) return null;
            this.current = this.open.get(0);
            this.open.remove(0);
            this.closed.add(this.current);
            addNeighborsToOpenList();
        }
        this.path.add(0, this.current);
        while (this.current.getCoordinate().getX() != this.start.getX() || this.current.getCoordinate().getY() != this.start.getY()) {
            this.current = this.current.getParent();
            this.path.add(0, this.current);
        }
        return this.path;
    }

    /**
     * Looks in a given list for a neighbors node
     *
     * @param nodes List(Node)
     * @param node  Node
     * @return boolean
     */
    private static boolean findNeighborInList(List<Node> nodes, Node node) {
        return nodes.stream().anyMatch(n -> n.getCoordinate().getX() == node.getCoordinate().getX() && n.getCoordinate().getY() == node.getCoordinate().getY());
    }

    /**
     * Calculate distance between current and end target.
     * If diagonal search is allowed, calculate the Euclidean distance.
     * If diagonal search is not allowed, calculate the Manhattan distance.
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
     * Add neighbors to open list for pathfinding
     */
    private void addNeighborsToOpenList() {
        Node node;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (!this.diagonal && x != 0 && y != 0) continue; // skip if diagonalonal movement is'nt allowed
                node = new Node(this.current, new Coordinate(this.current.getCoordinate().getX() + x, this.current.getCoordinate().getY() + y), this.current.getG(), this.distance(new Coordinate(x, y)));
                if ((x != 0 || y != 0) // not this.now
                        && this.current.getCoordinate().getX() + x >= 0 && this.current.getCoordinate().getX() + x < this.maze[0].length // check maze boundaries
                        && this.current.getCoordinate().getY() + y >= 0 && this.current.getCoordinate().getY() + y < this.maze.length
                        && this.maze[this.current.getCoordinate().getY() + y][this.current.getCoordinate().getX() + x] != 0 // check if square is walkable
                        && !findNeighborInList(this.open, node) && !findNeighborInList(this.closed, node)) { // if not already done
                    node.setG(node.getParent().getG() + 1); // Horizontal/vertical cost = 1.0
                    node.setG(node.getG() + maze[this.current.getCoordinate().getY() + y][this.current.getCoordinate().getX() + x]); // add movement cost for this square
                    this.open.add(node);
                }
            }
        }
        Collections.sort(this.open);
    }
}
