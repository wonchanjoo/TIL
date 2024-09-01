import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    static int V, E, K;
    static List<Node>[] adjList;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        adjList = new List[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList();
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[u].add(new Node(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF");
            } else {
                sb.append(dist[i]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[K] = 0;
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.idx]) {
                continue;
            }
            visited[now.idx] = true;

            for (int i = 0; i < adjList[now.idx].size(); i++) {
                Node next = adjList[now.idx].get(i);
                if (dist[next.idx] > dist[now.idx] + next.cost) {
                    dist[next.idx] = dist[now.idx] + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            if (this.cost == node.cost) {
                return this.idx - node.idx;
            }

            return this.cost - node.cost;
        }
    }
}