import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = 0, end = 0, count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int sum = A[start];
        while(true) {
            if(sum == M) {
                count++;
            }

            if(sum >= M) {
                sum -= A[start];
                start++;
                if(start >= N) {
                    break;
                }
            } else {
                end++;
                if(end >= N) {
                    break;
                }
                sum += A[end];
            }
        }

        System.out.println(count);
    }
}
