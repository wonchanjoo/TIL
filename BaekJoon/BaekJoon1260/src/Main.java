import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visited1;
    private static boolean[] visited2;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited1 = new boolean[N + 1];
        visited2 = new boolean[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(V);
        sb.append('\n');
        bfs(V);
        System.out.println(sb.toString());
    }

    private static void dfs(int node) {
        visited1[node] = true;
        sb.append(node).append(' ');
        for(int i = 0; i < graph[node].length; i++) {
            if(graph[node][i] == 1 && !visited1[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);
        visited2[node] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            sb.append(n).append(' ');

            for (int i = 0; i < graph[n].length; i++) {
                if(graph[n][i] == 1 && !visited2[i]) {
                    queue.offer(i);
                    visited2[i] = true;
                }
            }
        }
    }
}
