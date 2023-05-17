import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int INF = -1;

    public static void main(String[] args) throws IOException {
       new Main().solution();
    }

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        List<Integer> answer = new ArrayList<>();
        int[] dist = new int[N + 1]; // 최단거리
        Arrays.fill(dist, INF); // -1로 초기화
        Queue<Integer> q = new ArrayDeque<>();
        q.add(X);
        dist[X] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if(dist[cur] > K) break;
            if(dist[cur] == K) {
                answer.add(cur);
                continue;
            }

            for (int next : graph[cur]) {
                if(dist[next] == INF) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append('\n');
        }

        System.out.println(answer.isEmpty() ? -1 : sb);
    }
}