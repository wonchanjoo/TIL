import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 1, end = 1;
        int sum = 1, count = 0;

        while(start <= end) {
            if(sum == N) {
                count++;
            }

            if(sum < N) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}
