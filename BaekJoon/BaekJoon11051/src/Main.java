import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 입력 끝

        DP = new int[N + 1][N + 1];

        for(int i = 0; i <= N; i++) {
            DP[i][0] = 1;
            DP[i][1] = i;
            DP[i][i] = 1;
        }

        for(int n = 2; n <= N; n++)
            for(int r = 2; r < n; r++) {
                DP[n][r] = (DP[n - 1][r] + DP[n - 1][r - 1]) % 10007;
            }

        System.out.println(DP[N][K]);
    }
}