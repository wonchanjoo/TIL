import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();
        int[] sec = new int[1000001];
        int s = 0;

        q.offer(N);
        sec[N] = 0;
        while(!q.isEmpty()) {
            int n = q.poll();
            if(n == K)
                break;
            if(sec[n] == s)
                s++;

            if(n > 0 && sec[n - 1] == 0) {
                sec[n - 1] = s;
                q.offer(n - 1);
            }
            if(n < 100000 && sec[n + 1] == 0) {
                sec[n + 1] = s;
                q.offer(n + 1);
            }
            if((n * 2) < 1000000 && sec[n * 2] == 0) {
                sec[n * 2] = s;
                q.offer(n * 2);
            }
        }

        System.out.println(sec[K]);
    }
}