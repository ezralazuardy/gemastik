package elimination.challenge_02;

import java.util.*;

// A* Search Algorithm Implementation
public class Pathfinder {

    private final List<Node> open;
    private final List<Node> closed;
    private final List<Node> path;
    private final int[][] maze;
    private Node current;
    private final Coordinate start;
    private Coordinate end;
    private final boolean diag;

    public Pathfinder(int[][] maze, Coordinate start, boolean diag) {
        this.open = new ArrayList<>();
        this.closed = new ArrayList<>();
        this.path = new ArrayList<>();
        this.maze = maze;
        this.current = new Node(null, start, 0, 0);
        this.start = start;
        this.diag = diag;
    }

    /**
     * Finds path to target or returns null
     */
    public List<Node> findPathTo(Coordinate target) {
        this.end = target;
        this.closed.add(this.current);
        addNeighborsToOpenList();
        while (this.current.coordinate.getX() != this.end.getX() || this.current.coordinate.getY() != this.end.getY()) {
            if (this.open.isEmpty()) return null;
            this.current = this.open.get(0);
            this.open.remove(0);
            this.closed.add(this.current);
            addNeighborsToOpenList();
        }
        this.path.add(0, this.current);
        while (this.current.coordinate.getX() != this.start.getX() || this.current.coordinate.getY() != this.start.getY()) {
            this.current = this.current.parent;
            this.path.add(0, this.current);
        }
        return this.path;
    }

    /**
     * Looks in a given list for a neighbors node
     */
    private static boolean findNeighborInList(List<Node> nodes, Node node) {
        return nodes.stream().anyMatch(n -> n.coordinate.getX() == node.coordinate.getX() && n.coordinate.getY() == node.coordinate.getY());
    }

    /**
     * Calculate distance between current and end target
     */
    private double distance(Coordinate target) {
        if (this.diag) {
            // Hypothenuse
            return Math.hypot(this.current.coordinate.getX() + target.getX() - this.end.getX(), this.current.coordinate.getY() + target.getY() - this.end.getY());
        } else {
            // Manhattan distance
            return Math.abs(this.current.coordinate.getX() + target.getX() - this.end.getX()) + Math.abs(this.current.coordinate.getY() + target.getY() - this.end.getY());
        }
    }

    /**
     * Add neighbors to open list for pathfinding
     */
    private void addNeighborsToOpenList() {
        Node node;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (!this.diag && x != 0 && y != 0)
                    continue; // skip if diagonal movement is'nt allowed
                node = new Node(this.current, new Coordinate(this.current.coordinate.getX() + x, this.current.coordinate.getY() + y), this.current.g, this.distance(new Coordinate(x, y)));
                if ((x != 0 || y != 0) // not this.now
                        && this.current.coordinate.getX() + x >= 0 && this.current.coordinate.getX() + x < this.maze[0].length // check maze boundaries
                        && this.current.coordinate.getY() + y >= 0 && this.current.coordinate.getY() + y < this.maze.length
                        && this.maze[this.current.coordinate.getY() + y][this.current.coordinate.getX() + x] != 0 // check if square is walkable
                        && !findNeighborInList(this.open, node) && !findNeighborInList(this.closed, node)) { // if not already done
                    node.g = node.parent.g + 1.; // Horizontal/vertical cost = 1.0
                    node.g += maze[this.current.coordinate.getY() + y][this.current.coordinate.getX() + x]; // add movement cost for this square
                    this.open.add(node);
                }
            }
        }
        Collections.sort(this.open);
    }
}
