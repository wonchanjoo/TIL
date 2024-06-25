import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] value;
    static int[] dp; // i 가치를 만들수 있는 경우의 수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        value = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        // dp 계산
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = value[i]; j <= k; j++) {
                dp[j] += dp[j - value[i]];
            }
        }

        System.out.println(dp[k]);
    }
}