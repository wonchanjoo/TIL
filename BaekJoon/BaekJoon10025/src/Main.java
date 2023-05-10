import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000001];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
        }

        int start = 0, end = K * 2 + 1, sum = 0;
        if(end >= arr.length) {
            end = arr.length - 1;
        }
        for(int i = start; i < end; i++) {
            sum += arr[i];
        }
        int max = sum;
        while(end < arr.length) {
            if(sum > max) {
                max = sum;
            }

            sum -= arr[start++];
            sum += arr[end++];
        }

        System.out.println(max);
    }
}
