import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x > 0) {
                queue.offer(x);
            } else {
                if(queue.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(queue.poll()).append('\n');
                }
            }
        }

        System.out.println(sb.toString());
    }
}
