import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static List<Integer> sum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 두 수의 합을 구한다.
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(sum);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (binarySearch(arr[j] - arr[i])) {
                    answer = Math.max(answer, arr[j]);
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean binarySearch(int n) {
        int L = 0;
        int R = sum.size();

        while (L <= R) {
            int mid = (L + R) / 2;

            if (sum.get(mid) < n) {
                L = mid + 1;
            } else if (sum.get(mid) > n) {
                R = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}