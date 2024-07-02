import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Node> deque = new ArrayDeque<>();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.offer(new Node(i, Integer.parseInt(st.nextToken())));
        }

        while (true) {
            Node now = deque.poll();
            sb.append(now.idx).append(' ');

            if (deque.isEmpty()) {
                break;
            }

            if (now.value < 0) {
                for (int i = 0; i < Math.abs(now.value); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            } else {
                for (int i = 0; i < (now.value - 1); i++) {
                    deque.offerLast(deque.pollFirst());
                }
            }
        }

        System.out.println(sb);
    }

    static class Node {
        int idx, value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}