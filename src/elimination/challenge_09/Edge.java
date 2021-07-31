package elimination.challenge_09;

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
