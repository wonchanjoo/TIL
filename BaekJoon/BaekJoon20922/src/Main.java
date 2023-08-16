import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int[] a;
    static int[] count = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        a = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int start = 0;
        int end = 0;
        while (end < N) {
            count[a[end]]++;

            if (count[a[end]] > K) {
                while (count[a[end]] != K) {
                    count[a[start++]]--;
                }
            }

            max = Math.max(max, end - start + 1);
            end++;
        }

        System.out.println(max);
    }
}