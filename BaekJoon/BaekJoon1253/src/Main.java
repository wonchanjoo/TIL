import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int L = 0;
            int R = N - 1;

            while (L < R) {
                if (L == i) {
                    L++;
                    continue;
                } else if (R == i) {
                    R--;
                    continue;
                }

                long sum = A[L] + A[R];
                if (sum < A[i]) {
                    L++;
                } else if (sum > A[i]) {
                    R--;
                } else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}