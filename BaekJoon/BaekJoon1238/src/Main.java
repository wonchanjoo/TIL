import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 1_00_000_000;

    static int N, M, X;	// N: 도시의 수 / M: 버스의 수 / X: 파티를 하는 마을 번호
    static int[] dist;
    static ArrayList[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        initList();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[start].add(new Edge(dest, time));
        }

        int max = -1;
        for (int i = 1; i <= N; i++) {
            int temp = dijkstra(i, X);
            temp += dijkstra(X, i);

            if (temp > max) {
                max = temp;
            }
        }

        System.out.println(max);
    }

    private static void initDistArr() {
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }
    }

    private static void initList() {
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
    }

    private static int dijkstra(int start, int dest) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        initDistArr();

        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.vertex == dest) {
                break;
            }

            if (dist[now.vertex] < now.weight) {
                continue;
            }

            int size = list[now.vertex].size();
            for (int i = 0; i < size; i++) {
                Edge next = (Edge) list[now.vertex].get(i);

                if (dist[next.vertex] > dist[now.vertex] + next.weight) {
                    dist[next.vertex] = dist[now.vertex] + next.weight;
                    pq.offer(new Edge(next.vertex, dist[next.vertex]));
                }
            }
        }

        return dist[dest];
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