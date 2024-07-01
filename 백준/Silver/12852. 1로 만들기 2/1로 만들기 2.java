import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static Node[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new Node[N + 1];

        // dp 초기화
        for (int i = 0; i < N; i++) {
            dp[i] = new Node(i, -1, Integer.MAX_VALUE);
        }
        dp[N] = new Node(N, -1, 0);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        int[] tmp = new int[3];
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == 1) {
                break;
            }

            if (x % 3 == 0) {
                tmp[0] = x / 3;
            } else {
                tmp[0] = -1;
            }
            if (x % 2 == 0) {
                tmp[1] = x / 2;
            } else {
                tmp[1] = -1;
            }
            tmp[2] = x - 1;

            for (int i = 0; i < 3; i++) {
                if (tmp[i] > 0 && dp[tmp[i]].count > dp[x].count + 1) {
                    dp[tmp[i]].count = dp[x].count + 1;
                    dp[tmp[i]].pre = x;
                    queue.offer(tmp[i]);
                }
            }
        }

        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(dp[1].count).append('\n');

        List<Integer> answer = new ArrayList<>();
        answer.add(1);

        int i = 1;
        while (i != N) {
            i = dp[i].pre;
            answer.add(i);
        }

        for (i = answer.size() - 1; i >= 0; i--) {
            sb.append(answer.get(i)).append(' ');
        }

        System.out.println(sb);
    }

    static class Node {
        int num, pre, count;

        public Node(int num, int pre, int count) {
            this.num = num;
            this.pre = pre;
            this.count = count;
        }
    }
}