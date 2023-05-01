import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        make1(N);
        System.out.println(dp[N]);
    }

    private static int make1(int n) {
        if(n == 1 || n == 0) {
            return 0;
        }

        if(dp[n] == 0) {
            if (n % 6 == 0) {
                dp[n] = Math.min(make1(n - 1), Math.min(make1(n / 2), make1(n / 3))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(make1(n / 3), make1(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(make1(n / 2), make1(n - 1)) + 1;
            } else {
                dp[n] = make1(n - 1) + 1;
            }
        }

        return dp[n];
    }
}
