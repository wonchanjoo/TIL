import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_VALUE = 100_001;
    static int n, k;
    static int[] value, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        value = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());

            // k 보다 큰 가치는 필요 없다.
            if (value[i] > k) {
                continue;
            }

            dp[value[i]] = 1;
        }

        Arrays.sort(value);

        // dp[i] = 가치의 합이 i원일 때의 최소 동전 개수
        for (int i = value[0] + 1; i <= k; i++) {
            if (dp[i] == 1) {
                continue;
            }

            dp[i] = MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int value1 = value[j];
                int value2 = i - value[j];

                if (exception(value1, value2)) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[value1] + dp[value2]);
            }

            dp[i] = dp[i] == MAX_VALUE ? 0 : dp[i];
        }

        if (dp[k] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }

    private static boolean exception(int value1, int value2) {
        // 범위를 벗어나는 경우
        if (value1 < 0 || value2 < 0) {
            return true;
        }

        // 동전의 가치가 k를 넘는 경우
        if (value1 > k || value2 > k) {
            return true;
        }

        // 가치를 만들 수 없는 경우
        if (dp[value1] == 0 || dp[value2] == 0) {
            return true;
        }

        return false;
    }
}