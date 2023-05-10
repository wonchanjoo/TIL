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
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int start = 0, end = 0;
        while(start <= end) {
            count[a[end]]++;
            if(count[a[end]] > K) {
                count[a[start]]--;
            }

            if(end == a.length - 1) {
                start++;
            } else {
                end++;
            }
        }
    }
}
