import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K, N;    // K: 오영식이 이미 가지고 있는 랜선의 개수 / N: 필요한 랜선의 개수
    static int[] LAN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        LAN = new int[K];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            LAN[i] = Integer.parseInt(br.readLine());
            if (min > LAN[i])   min = LAN[i];
        }

        long L = 0;
        long R = min + 1; // 입력 받은 랜선의 길이 중 가장 짧은 것
        while (L < R) {
            long mid = (L + R) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += LAN[i] / mid;
            }

            if (count < N) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(L - 1);
    }
}
