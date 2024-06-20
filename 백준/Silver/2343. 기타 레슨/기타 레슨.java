import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        size = new int[N];

        int L = 0;
        int R = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            size[i] = Integer.parseInt(st.nextToken());
            L = Math.max(L, size[i]);
            R += size[i];
        }

        while (L < R) {
            int mid = (L + R) / 2;

            if (check(mid) <= M) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(L);
    }

    private static int check(int mid) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += size[i];

            if (sum > mid) {
                count++;
                sum = size[i];
            }
        }

        return count;
    }
}