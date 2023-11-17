import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] answer = new int[]{1_000_000_000, 1_000_000_000};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N - 1;
        while (start < end) {
            int sum =arr[start] + arr[end];

            if (Math.abs(sum) < Math.abs(answer[0] + answer[1])) {
                answer[0] = arr[start];
                answer[1] = arr[end];
            }

            if (sum >= 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}