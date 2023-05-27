import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()); // 현재 위치
        int G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        if(U == 0 || D == 0) {
            System.out.println("use the stairs");
            return;
        }

        boolean[] visited = new boolean[F + 1];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        q.add(S);

        while (!q.isEmpty()) {
            int n = q.poll();
            visited[n] = true;

            if(n < G) {
                if(n + U > F && !visited[n - D]) {
                    q.add(n - D);
                } else if(!visited[n + U]){
                    q.add(n + U);
                }
                count++;
            } else if(n > G) {
                if(n - D < 1 && !visited[n + U]) {
                    q.add(n + U);
                } else if(!visited[n - D]){
                    q.add(n - D);
                }
                count++;
            } else {
                break;
            }
        }

        if(q.isEmpty())
            System.out.println(count);
        else
            System.out.println("use the stairs");
    }
}