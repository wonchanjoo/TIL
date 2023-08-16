import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A;
    static int[] dp;
    static List<Integer> LIS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        LIS.add(A[0]);
        for (int i = 1; i < N; i++) {
            if (LIS.get(LIS.size() - 1) < A[i]) {
                LIS.add(A[i]);
            } else {
                int idx = lowerBound(0, LIS.size() - 1, A[i]);
                LIS.set(idx, A[i]);
            }
        }

        System.out.println(LIS.size());
    }

    private static int lowerBound(int L, int R, int value) {
        while (L < R) {
            int mid = (L + R) / 2;

            if (LIS.get(mid) >= value) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        return R;
    }
}