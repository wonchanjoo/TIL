import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K, N;    // K: 오영식이 이미 가지고 있는 랜선의 개수 / N: 필요한 랜선의 개수
    static int[] LAN;
    static int answer = 0;

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

        int L = 0;
        int R = min;
        while (L <= R) {
            int mid = (L + R) / 2;
            int result = cutting(mid);

            if (result == 0) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // length: 자르는 길이
    private static int cutting(int length) {
        int count = 0;

        for (int lan : LAN) {
            count += lan / length;
        }

        if (count < N) {
            return 0;
        } else {
            return length * count;
        }
    }
}
