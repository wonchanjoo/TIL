import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] graph;
    private static boolean[] visited;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        int M = Integer.parseInt(st.nextToken()); // 간선
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for(int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for(int i = 1; i < graph[node].length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
