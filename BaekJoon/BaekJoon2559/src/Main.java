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
        int[] temperature = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i < K; i++) {
            sum += temperature[i];
        }

        int start = 0;
        int end = start + K;
        int max = sum;
        while(end < N) {
            sum -= temperature[start++];
            sum += temperature[end++];
            if(sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}
