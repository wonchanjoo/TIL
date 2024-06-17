import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> negative = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 0) {
                positive.offer(n);
            } else {
                negative.offer(n);
            }
        }

        int answer = 0;
        while (!positive.isEmpty()) {
            int now = positive.poll();
            if (!positive.isEmpty()) {
                int next = positive.peek();
                if (next == 1) {
                    answer += now;
                } else {
                    answer += now * positive.poll();
                }
            } else {
                answer += now;
            }
        }
        while (!negative.isEmpty()) {
            int now = negative.poll();
            if (!negative.isEmpty()) {
                answer += now * negative.poll();
            } else {
                answer += now;
            }
        }

        System.out.println(answer);
    }
}