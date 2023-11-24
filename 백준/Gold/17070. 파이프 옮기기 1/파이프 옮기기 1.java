import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] home;
    static int[][][] dp;

    static int[] dirR = {0, 1, 1}; // → ↘︎ ↓
    static int[] dirC = {1, 1, 0}; // → ↘︎ ↓

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        home = new int[N][N];
        dp = new int[N][N][3];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                home[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // dp[r][c][direction] : direction에서 (r, c)로 올 수 있는 횟수
        dp[0][1][0] = 1;

        for (int r = 0; r < N; r++) {
            for (int c = 2; c < N; c++) {
                if (home[r][c] == 1) {
                    continue;
                }

                // 가로
                dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2];

                // 세로
                if (r - 1 >= 0) {
                    dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2];
                }

                // 대각선
                if (r - 1 >= 0 && home[r][c - 1] == 0 && home[r - 1][c] == 0) {
                    dp[r][c][2] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }
}