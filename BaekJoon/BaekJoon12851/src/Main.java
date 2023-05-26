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

        if(N == K) {
            System.out.println(0);
            System.out.println(1);
        } else {

            StringBuilder sb = new StringBuilder();
            Deque<Integer> q = new ArrayDeque<>();
            int[] sec = new int[1000001];
            int s = 0;
            int c = 0;

            q.offer(N);
            sec[N] = 0;
            while (!q.isEmpty()) {
                if (sec[q.peek()] == s) // 초 업데이트
                    s++;
                if (sec[K] != 0 && s > sec[K]) // 동생을 찾은 후
                    break;
                int n = q.poll();

                if (n > 0 && (sec[n - 1] == 0 || sec[n - 1] == s)) {
                    sec[n - 1] = s;
                    q.offer(n - 1);
                }
                if (n < 100000 && (sec[n + 1] == 0 || sec[n + 1] == s)) {
                    sec[n + 1] = s;
                    q.offer(n + 1);
                }
                if ((n * 2) < 1000000 && (sec[n * 2] == 0 || sec[n * 2] == s)) {
                    sec[n * 2] = s;
                    q.offer(n * 2);
                }
            }

            while (!q.isEmpty()) {
                if (q.poll() == K)
                    c++;
            }

            sb.append(sec[K]).append('\n').append(c);
            System.out.println(sb);
        }
    }
}