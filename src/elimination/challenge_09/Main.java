package elimination.challenge_09;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        final int[] negative = new int[m];
        final ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) in.nextInt();

        for (int i = 0; i < m; i++) negative[i] = in.nextInt();

        while (k-- > 0) {

            final int x = in.nextInt(), y = in.nextInt(), w = in.nextInt();

            boolean positive = true;

            // ensure no negative city is added
            for (int entry : negative) {
                if (x == entry || y == entry) {
                    positive = false;
                    break;
                }
            }

            // if positive city is detected, add current path
            if (positive) edges.add(new Edge(x, y, w));
        }

        final ArrayList<Edge> result = new Graph(n, edges).kruskal();

        int weight = 0;

        for (Edge edge : result) weight += edge.getWeight();

        System.out.println(weight);

        in.close();
    }
}
