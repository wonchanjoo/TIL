import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        for (int i = 1; i * i <= N; i++) {
            dp[i * i] = 1;
        }

        int tmp = 1;
        for (int i = 2; i <= N; i++) {
            if (dp[i] == 1) {
                tmp++;
                continue;
            }

            dp[i] = dp[i - tmp * tmp] + 1;
            for (int j = tmp - 1; j >= 1; j--) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + dp[j * j]);
            }
        }

        System.out.println(dp[N]);
    }
}