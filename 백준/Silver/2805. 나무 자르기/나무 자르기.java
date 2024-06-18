import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];

        long L = 0;
        long R = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            R = Math.max(R, trees[i]);
        }

        while (L < R) {
            long mid = (L + R) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    sum += (trees[i] - mid);
                }
            }

            if (sum >= M) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }

        System.out.println(R - 1);
    }
}