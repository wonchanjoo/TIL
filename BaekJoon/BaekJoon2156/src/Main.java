import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] data;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        data = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        // dp 초기화
        dp[1] = data[1];
        if (n >= 2)  dp[2] = data[1] + data[2];

        // dp
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + data[i - 1]) + data[i];
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}