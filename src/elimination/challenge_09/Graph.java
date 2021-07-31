package elimination.challenge_09;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private final int v;
    private final Edge[] edges;

    public Graph(int v, ArrayList<Edge> edges) {
        this.v = v;
        this.edges = edges.toArray(Edge[]::new);
    }

    private int find(Subset[] subsets, int i) {
        if (subsets[i].getParent() != i)
            subsets[i].setParent(find(subsets, subsets[i].getParent()));
        return subsets[i].getParent();
    }

    private void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x), yRoot = find(subsets, y);
        if (subsets[xRoot].getRank() < subsets[yRoot].getRank())
            subsets[xRoot].setParent(yRoot);
        else if (subsets[xRoot].getRank() > subsets[yRoot].getRank())
            subsets[yRoot].setParent(xRoot);
        else {
            subsets[yRoot].setParent(xRoot);
            subsets[xRoot].setRank(subsets[xRoot].getRank() + 1);
        }
    }

    public ArrayList<Edge> kruskal() {
        final ArrayList<Edge> results = new ArrayList<>();
        int e = 0, i = 0;

        Arrays.sort(this.edges);
        Subset[] subsets = new Subset[v];
        for (int j = 0; j < subsets.length; j++) {
            subsets[j] = new Subset(j, 0);
        }

        while (e < v - 1) {
            Edge next = this.edges[i++];
            int x = find(subsets, next.getSource());
            int y = find(subsets, next.getDestination());
            if (x != y) {
                e++;
                results.add(next);
                union(subsets, x, y);
            }
        }

        return results;
    }
}
