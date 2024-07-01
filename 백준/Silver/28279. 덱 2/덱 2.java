import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.pollFirst()).append('\n');
                    }
                    break;
                case 4:
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.pollLast()).append('\n');
                    }
                    break;
                case 5:
                    sb.append(deque.size()).append('\n');
                    break;
                case 6:
                    if (deque.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case 7:
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.peekFirst()).append('\n');
                    }
                    break;
                case 8:
                    if (deque.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.peekLast()).append('\n');
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}