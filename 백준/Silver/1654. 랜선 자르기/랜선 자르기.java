import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int K, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        long L = 0;
        long R = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            R = Math.max(R, arr[i]);
        }

        R++;

        while (L < R) {
            long mid = (L + R) / 2;

            long count = 0;
            for (int i = 0; i < K; i++) {
                count += (arr[i] / mid);
            }

            if (count >= N) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }

        System.out.println(R - 1);
    }
}