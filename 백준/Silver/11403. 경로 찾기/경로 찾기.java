import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][] arr;
    static int[][] answer;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new boolean[N][N];
        answer = new int[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = (Integer.parseInt(st.nextToken()) == 1);
            }
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(answer[r][c]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void bfs(int n) {
        visited = new boolean[N][N];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < N; i++) {
                if (arr[now][i] && !visited[now][i]) {
                    answer[n][i] = 1;
                    visited[now][i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}