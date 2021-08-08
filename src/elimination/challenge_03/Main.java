package elimination.challenge_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        final Reader in = new Reader();



        in.close();
    }

    public class Edge implements Comparable {

        private final Node node;
        private final int weight;

        public Edge(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(((Edge) o).getWeight(), this.getWeight());
        }

        public Node getTargetNode() {
            return this.node;
        }

        public int getWeight() {
            return this.weight;
        }
    }

    public class Node implements Comparable {

        private final PriorityQueue<Edge> edges;
        private final int id;
        private final double h;
        private double g;
        private Node parent;

        public Node(int id, int h) {
            this.edges = new PriorityQueue<>();
            this.id = id;
            this.h = h;
            this.g = 0;
        }

        @Override
        public int compareTo(Object o) {
            return Double.compare(this.getF(), ((Node) o).getF());
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Node)) return false;
            return this.getId() == ((Node) o).getId();
        }

        public void addBranch(Node neighbor, int weight) {
            this.edges.add(new Edge(neighbor, weight));
        }

        public Node getParent() {
            return this.parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
            this.g = this.parent.getG();
        }

        public PriorityQueue<Edge> getEdges() {
            return this.edges;
        }

        public int getId() {
            return this.id;
        }

        public double getG() {
            return this.g;
        }

        public void incrementG(double pathPrice) {
            this.g += +pathPrice;
        }

        public double getH() {
            return this.h;
        }

        public double getF() {
            return this.getG() + this.getH();
        }
    }

    public class Pathfinder {

        private final PriorityQueue<Node> open, closed;
        private final Node start;
        private Node current;

        public Pathfinder(Node start) {
            this.open = new PriorityQueue<>();
            this.closed = new PriorityQueue<>();
            this.start = start;
        }

        public List<Node> find(Node target) {
            this.current = start;
            scanNeighbors();
            while (!this.current.equals(target)) {
                if (this.open.isEmpty()) return new ArrayList<>();
                this.current = this.open.poll();
                scanNeighbors();
            }
            return reconstructPath(target);
        }

        private List<Node> reconstructPath(Node target) {
            if (!this.current.equals(target))
                throw new IllegalStateException("There is no path found to the target node!");
            final List<Node> path = new ArrayList<>();
            path.add(0, current);
            while (!current.equals(start)) {
                this.current = this.current.getParent();
                path.add(0, current);
            }
            return path;
        }

        private void scanNeighbors() {
            this.closed.add(this.current);
            for (Edge edge : this.current.getEdges()) {
                final Node neighbor = edge.getTargetNode();
                if (!this.open.contains(neighbor) && !this.closed.contains(neighbor)) {
                    neighbor.setParent(this.current);
                    neighbor.incrementG(edge.getWeight());
                    this.open.add(neighbor);
                } else if (this.current.getG() + edge.getWeight() < neighbor.getG()) {
                    neighbor.setParent(this.current);
                    neighbor.incrementG(edge.getWeight());
                    this.open.add(neighbor);
                    this.closed.remove(neighbor);
                }
            }
        }
    }

    public static class Reader {

        private final BufferedReader br;
        private StringTokenizer st;

        public Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() throws NumberFormatException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws NumberFormatException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws NumberFormatException {
            return Double.parseDouble(next());
        }

        public void close() {
            try {
                if (br == null) return;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
