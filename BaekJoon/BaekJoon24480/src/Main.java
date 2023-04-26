import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for(int i = 0; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        for(int i = 1; i <= N; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int r) {
        visited[r] = true;
        answer[r] = count++;

        for(int i = graph[r].size() - 1; i >= 0; i--) {
            if(!visited[graph[r].get(i)]) {
                dfs(graph[r].get(i));
            }
        }
    }
}
