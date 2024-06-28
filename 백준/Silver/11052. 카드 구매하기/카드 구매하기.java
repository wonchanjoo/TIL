import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] P;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        P = new int[N + 1];
        cost = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = cost[i] = Integer.parseInt(st.nextToken());
        }

        // 금액 계산
        for (int i = 2; i <= N; i++) {
            count(i);
        }

        System.out.println(cost[N]);
    }

    private static void count(int n) {
        for (int i = 1; i <= (n / 2); i++) {
            cost[n] = Math.max(cost[n], cost[i] + cost[n - i]);
        }
    }
}