import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N, M;
    static int[][] dp; // 0 왼쪽 1 원래 자리 2 오른쪽
    static Set<Integer> VIP = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][3];

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            VIP.add(Integer.parseInt(br.readLine()));
        }

        if (!VIP.contains(1)) {
            dp[1][2] = 1;
        }
        dp[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            if (VIP.contains(i)) {
                dp[i][0] = 0;
                dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
                dp[i][2] = 0;
            } else {
                dp[i][0] = dp[i - 1][0] + dp[i - 1][2];
                dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
                dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            }
        }

        System.out.println(dp[N][2]);
    }
}