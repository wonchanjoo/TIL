import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c) - '0';
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int r, int c, int cnt) {
        if (cnt >= answer) {
            return;
        }

        if (r == (N - 1) && c == (M - 1)) {
            answer = Math.min(cnt, answer);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dirR[i];
            int nextC = c + dirC[i];

            if (rangeIn(nextR, nextC) && !visited[nextR][nextC]) {
                visited[nextR][nextC] = true;

                if (map[nextR][nextC] == 1) {
                    dfs(nextR, nextC, cnt + 1);
                } else {
                    dfs(nextR, nextC, cnt);
                }

                visited[nextR][nextC] = false;
            }
        }
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < M);
    }
}