import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        max.offer(Integer.parseInt(br.readLine()));
        sb.append(max.peek()).append('\n');
        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (max.peek() >= n) {
                max.offer(n);
            } else {
                min.offer(n);
            }

            while (min.size() > max.size()) {
                max.offer(min.poll());
            }
            while (max.size() - min.size() > 1) {
                min.offer(max.poll());
            }

            sb.append(max.peek()).append('\n');
        }

        System.out.println(sb);
    }
}