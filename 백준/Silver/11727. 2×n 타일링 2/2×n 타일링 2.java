import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 10_007;
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        dp[1] = 1;
        if (n > 1) {
            dp[2] = 3;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % MOD;
        }

        System.out.println(dp[n]);
    }
}