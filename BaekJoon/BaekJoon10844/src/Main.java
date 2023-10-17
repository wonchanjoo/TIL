import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1_000_000_000;
    static int N;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        DP = new int[N + 1][3];
        DP[1][0] = 0;
        DP[1][1] = 1;
        DP[1][2] = 8;

        for (int i = 2; i <= N; i++) {
            DP[i][0] = DP[i - 1][1];
            DP[i][1] = DP[i - 1][0];
        }

        System.out.println(DP[N]);
    }
}