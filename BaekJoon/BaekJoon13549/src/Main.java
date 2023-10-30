import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static final int MIN = 0;
    static final int MAX = 100001;

    static int N, K;
    static int[] cost;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K) {
            System.out.println(0);
            return;
        }

        cost = new int[100001];
        visited = new boolean[100001];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(N);
        cost[N] = 0;
        visited[N] = true;

        int[] next = new int[3];
        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now == K) {
                break;
            }

            next[0] = now * 2;
            if (rangeIn(next[0]) && (!visited[next[0]] || cost[now] < cost[next[0]])) {
                cost[next[0]] = cost[now];
                visited[next[0]] = true;
                deque.offerFirst(next[0]);
            }

            next[1] = now - 1;
            next[2] = now + 1;
            for (int i = 1; i <= 2; i++) {
                if (rangeIn(next[i]) && (!visited[next[i]] || (cost[now] + 1) < cost[next[i]])) {
                    cost[next[i]] = cost[now] + 1;
                    visited[next[i]] = true;
                    deque.offerLast(next[i]);
                }
            }
        }

        System.out.println(cost[K]);
    }

    static boolean rangeIn(int n) {
        return (n >= MIN) && (n < MAX);
    }
}