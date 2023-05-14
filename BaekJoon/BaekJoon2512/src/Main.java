import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0, max = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        int M = Integer.parseInt(br.readLine());

        if(sum < M) { // 모든 요청이 배정될 수 있는 경우
            System.out.println(max);
        } else {
            int temp;
            for(int i = M / N; i <= sum / N; i++) {

            }
        }
    }
}
