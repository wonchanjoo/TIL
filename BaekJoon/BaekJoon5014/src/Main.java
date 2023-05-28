import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int F;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()); // 현재 위치
        int G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[F + 1];
        int count = -1;
        boolean find = false;

        while (true) {
            if(visited[S]) {
                break;
            }
            visited[S] = true;
            count++;

            if(S < G) {
                if((S + U) <= F)
                    S += U;
                else if((S - D) > 0)
                    S -= D;
            } else if(S > G) {
                if((S - D) > 0)
                    S -= D;
                else if((S + U) <= F)
                    S += U;
            } else { // 도착
                find = true;
                break;
            }
        }

        if(find)
            System.out.println(count);
        else
            System.out.println("use the stairs");
    }
}