import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] budget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        budget = new int[N];

        long L = 0;
        long R = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            R = Math.max(R, budget[i]);
        }

        M = Integer.parseInt(br.readLine());

        R++;

        while (L < R) {
            long mid = (L + R) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (budget[i] > mid) {
                    sum += mid;
                } else {
                    sum += budget[i];
                }
            }

            if (sum > M) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(R - 1);
    }
}