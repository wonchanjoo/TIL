import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, K;
    static int N = 0; // 조약돌 개수
    static int[] A;
    static long[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        A = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            N += A[i];
        }
        K = Integer.parseInt(br.readLine()); // 입력 끝

        DP = new long[N + 1][N + 1];

        for(int i = 0; i <= N; i++) {
            DP[i][0] = 1;
            DP[i][1] = i;
            DP[i][i] = 1;
        }

        // 조합
        for(int n = 2; n <= N; n++)
            for(int r = 2; r < n; r++)
                DP[n][r] = DP[n - 1][r] + DP[n - 1][r - 1];

        long sum = 0;
        for(int i = 0; i < M; i++)
            sum += DP[A[i]][K];

        System.out.println((double)sum / DP[N][K]);
    }
}
