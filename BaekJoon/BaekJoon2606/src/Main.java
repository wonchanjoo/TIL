import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, E;
    static int[][] computers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        computers = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        E = Integer.parseInt(br.readLine());
        for(int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a][b] = 1;
            computers[b][a] = 1;
        }

        bfs(1);

        int count = 0;
        for(int i = 2; i <= N; i++) {
            if(visited[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int node = q.poll();

            for(int i = 0; i <= N; i++) {
                if(!visited[i] && computers[node][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }

        }
    }
}
