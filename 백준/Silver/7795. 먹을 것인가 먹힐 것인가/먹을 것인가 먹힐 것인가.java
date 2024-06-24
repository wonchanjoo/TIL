import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, N, M, answer;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            sb.append(solve()).append('\n');
        }

        System.out.println(sb);
    }

    private static int solve() {
        int[] dp = new int[N + 1];
        answer = 0;

        int idx = 0;
        for (int i = 0; i < N; i++) {
            dp[i + 1] = dp[i];

            while (idx < M && A[i] > B[idx]) {
                dp[i + 1]++;
                idx++;
            }

            answer += dp[i + 1];
        }

        return answer;
    }
}