import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, E, v1, v2;
    static List<Edge>[] adjList;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        initAdjList();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList[a].add(new Edge(b, c));
            adjList[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int[] path = {1, v1, v2, N};
        int answer1 = 0;
        for (int i = 0; i < 3; i++) {
            int distance = dijkstra(path[i], path[i + 1]);
            if (distance == Integer.MAX_VALUE) {
                answer1 = Integer.MAX_VALUE;
                break;
            }
            answer1 += distance;
        }

        // 1 -> v2 -> v1 -> N
        path = new int[]{1, v2, v1, N};
        int answer2 = 0;
        for (int i = 0; i < 3; i++) {
            int distance = dijkstra(path[i], path[i + 1]);
            if (distance == Integer.MAX_VALUE) {
                answer2 = Integer.MAX_VALUE;
                break;
            }
            answer2 += distance;
        }

        if (answer1 == Integer.MAX_VALUE && answer2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(answer1, answer2));
        }
    }

    private static void initAdjList() {
        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    private static void initDistArr() {
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
    }

    // start ~ end의 최단 경로의 길이를 반환한다.
    private static int dijkstra(int start, int end) {
        initDistArr();

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (dist[now.target] < now.weight) {
                continue;
            }

            for (int i = 0; i < adjList[now.target].size(); i++) {
                Edge next = adjList[now.target].get(i);

                if (dist[now.target] + next.weight < dist[next.target]) {
                    dist[next.target] = dist[now.target] + next.weight;
                    pq.offer(new Edge(next.target, dist[next.target]));
                }
            }
        }

        return dist[end];
    }

    static class Edge implements Comparable<Edge> {
        int target, weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }
}