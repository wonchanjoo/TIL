import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, D;
    static int[] dist;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            dist[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (v > D || (v - u <= w)) {
                continue;
            }

            pq.offer(new Edge(u, v, w));
        }

        // 시작점이 0인 경우 처리해주기
        while (!pq.isEmpty() && pq.peek().start == 0) {
            Edge edge = pq.poll();
            dist[edge.end] = Math.min(dist[edge.end], edge.cost);
        }

        for (int i = 1; i <= D; i++) {
            dist[i] = Math.min(dist[i - 1] + 1, dist[i]);

            while (!pq.isEmpty() && pq.peek().start == i) {
                Edge edge = pq.poll();
                dist[edge.end] = Math.min(dist[edge.end], dist[edge.start] + edge.cost);
            }
        }

        System.out.println(dist[D]);
    }

    static class Edge implements Comparable<Edge> {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge) {
            if (this.start == edge.start) {
                return this.cost - edge.cost;
            }
            return this.start - edge.start;
        }
    }
}