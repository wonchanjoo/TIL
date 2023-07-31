import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int V, E, K;
    static int[] D;
    static boolean[] visited;
    static ArrayList[] graph;
    static Deque<Integer> queue = new ArrayDeque<>();

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

        // 초깃값
        D[K] = 0;
        queue.offer(K);
        visited[K] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int i = 0; i < graph[n].size(); i++) {
                Edge e = (Edge) graph[n].get(i);

                if (D[e.vertex] > D[n] + e.weight)
                    D[e.vertex] = D[n] + e.weight;

                if (!visited[e.vertex]) {
                    queue.offer(e.vertex);
                    visited[e.vertex] = true;
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (D[i] == Integer.MAX_VALUE)
                sb.append("INF").append('\n');
            else
                sb.append(D[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void initGraph() {
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++)
            graph[i] = new ArrayList<Edge>();
    }

    private static void initArr() {
        D = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            D[i] = Integer.MAX_VALUE;
        }
    }

    static class Edge {
        int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
