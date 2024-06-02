import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] score;
    static boolean[][] visited;
    static int answer = 0;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        score = new int[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                score[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c]) {
                    visited[r][c] = true;
                    dfs(r, c, score[r][c], 1);
                    visited[r][c] = false;
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int r, int c, int sum, int count) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dirR[i];
            int nextC = c + dirC[i];

            if (rangeIn(nextR, nextC) && !visited[nextR][nextC]) {

                if (count == 2) {
                    visited[nextR][nextC] = true;
                    dfs(r, c, sum + score[nextR][nextC], count + 1);
                    visited[nextR][nextC] = false;
                }

                visited[nextR][nextC] = true;
                dfs(nextR, nextC, sum + score[nextR][nextC], count + 1);
                visited[nextR][nextC] = false;
            }
        }
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < M);
    }
}