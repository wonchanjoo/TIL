import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E, K;
    static int[] distance;
    static boolean[] visited;
    static ArrayList[] graph;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        initGraph();
        initArr();
        visited = new boolean[V + 1];

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
        }

        queue.offer(new Edge(K, 0));
        distance[K] = 0;

        while (!queue.isEmpty()) {
            Edge curr = queue.poll();

            if (visited[curr.vertex])  continue;

            visited[curr.vertex] = true;
            for (int i = 0; i < graph[curr.vertex].size(); i++) {
                Edge e = (Edge) graph[curr.vertex].get(i);

                if (distance[e.vertex] > distance[curr.vertex] + e.weight) {
                    distance[e.vertex] = distance[curr.vertex]+e.weight;
                    queue.offer(new Edge(e.vertex, distance[e.vertex]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF").append('\n');
            else
                sb.append(distance[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void initGraph() {
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++)
            graph[i] = new ArrayList<Edge>();
    }

    private static void initArr() {
        distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
}
