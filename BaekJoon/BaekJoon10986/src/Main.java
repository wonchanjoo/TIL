import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long[] sum; // 누적합 배열
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if ((sum[i] - sum[j]) % M == 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}