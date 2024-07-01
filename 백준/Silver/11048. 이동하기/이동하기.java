import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] dr = {-1, 0, -1};
    static final int[] dc = {0, -1, -1};

    static int N, M;
    static int[][] candy;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        candy = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                candy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 초기화
        dp[0][0] = candy[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + candy[i][0];
        }

        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + candy[0][i];
        }

        // dp 계산
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int max = 0;
                for (int k = 0; k < 3; k++) {
                    max = Math.max(max, dp[i + dr[k]][j + dc[k]]);
                }

                dp[i][j] = max + candy[i][j];
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}