import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            // 작업 끝나는 날이 N을 넘어가는 경우
            if (i + T[i] > (N + 1)) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(P[i] + dp[i + T[i]], dp[i + 1]);
            }
        }

        System.out.println(dp[1]);
    }
}