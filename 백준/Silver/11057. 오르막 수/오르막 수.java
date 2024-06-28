import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int mod = 10_007;
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10];

        // dp 초기화
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // dp 계산
        for (int i = 2; i <= N; i++) {
            int tmp = 0;
            for (int j = 0; j <= 9; j++) {
                tmp += dp[i - 1][j];
                dp[i][j] = tmp % mod;
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[N][i]) % mod;
        }
        System.out.println(answer);
    }
}