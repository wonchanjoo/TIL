import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int A, B;
    static Queue<Integer[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        BFS(A);

        if(q.isEmpty())
            System.out.println(-1);
        else {
            while (!q.isEmpty()) {
                if (q.peek()[0] == B) {
                    System.out.println(q.poll()[1]);
                    break;
                }
                q.poll();
            }
        }
    }

    private static void BFS(int A) {
        q = new LinkedList<>();

        q.offer(new Integer[]{A, 1});

        while(!q.isEmpty()) {
            int n = q.peek()[0];
            int c = q.poll()[1];

            // n * 2
            if(((long)n * 2) <= B) {
                q.offer(new Integer[]{n * 2, c + 1});
            }

            // n * 10 + 1
            if(((long)n * 10 + 1) <= B ) {
                q.offer(new Integer[]{n * 10 + 1, c + 1});
            }

            if((n * 2) == B || (n * 10 + 1) == B)
                break;
        }
    }
}