import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, n;
    static int[][] sticker;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sticker = new int[2][n];
            dp = new int[2][n];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dp 계산
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            for (int i = 1; i < n; i++) {
                dp[0][i] = Math.max(sticker[0][i] + dp[1][i - 1], dp[0][i - 1]);
                dp[1][i] = Math.max(sticker[1][i] + dp[0][i - 1], dp[1][i - 1]);
            }

            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append('\n');
        }
        System.out.println(sb);
    }
}