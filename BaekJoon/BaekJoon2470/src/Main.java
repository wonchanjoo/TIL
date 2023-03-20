import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int start = 0, end = N - 1; // index
        int temp = A[start] + A[end];
        int alkali = A[start], acid = A[end];
        while(start < end) {
            int sum = A[start] + A[end];
            if (Math.abs(sum) < Math.abs(temp)) {
                alkali = A[start];
                acid = A[end];
                temp = sum;
            }

            if(sum == 0) {
                break;
            } else if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(alkali + " " + acid);
    }
}
