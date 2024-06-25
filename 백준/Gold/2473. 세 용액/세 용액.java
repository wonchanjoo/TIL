import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static long[] arr;
    static long[] answer = new long[3];
    static long total = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            long sum = 0;
            int L = i + 1;
            int R = N - 1;

            while (L < R) {
                sum = arr[i] + arr[L] + arr[R];

                if (Math.abs(total) > Math.abs(sum)) {
                    total = sum;
                    answer[0] = arr[i];
                    answer[1] = arr[L];
                    answer[2] = arr[R];
                }

                if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                } else {
                    break;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}