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
            return;
        }

        boolean[] visited = new boolean[100001];
        int[] second = new int[100001];

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        visited[N] = true;
        second[N] = 0;
        while(!q.isEmpty()) {
            int i = q.poll();
            if(i == K)
                break;

            // i - 1
            if((i - 1) >= 0) {
                if(!visited[i - 1]) {
                    visited[i - 1] = true;
                    second[i - 1] = second[i] + 1;
                    q.offer(i - 1);
                } else if(second[i - 1] > second[i] + 1){
                    second[i - 1] = second[i] + 1;
                }
            }

            // i + 1
            if((i + 1) <= 100000 && !visited[i + 1]) {
                if(!visited[i + 1]) {
                    visited[i + 1] = true;
                    second[i + 1] = second[i] + 1;
                    q.offer(i + 1);
                } else if(second[i + 1] > second[i] + 1){
                    second[i + 1] = second[i] + 1;
                }
            }

            // i * 2
            if((i * 2 <= 100000)) {
                if(!visited[i * 2]) {
                    visited[i * 2] = true;
                    second[i * 2] = second[i];
                    q.offer(i * 2);
                } else if(second[i * 2] > second[i]){
                    second[i * 2] = second[i];
                }
            }
        }

        System.out.println(second[K]);
    }
}