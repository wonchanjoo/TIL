import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i <= K; i++) {
            pq.offer(new Node(i, arr[i]));
        }

        sb.append(pq.peek().value);
        int preIdx = pq.poll().idx;

        for (int i = 1; i < (N - K); i++) {
            pq.offer(new Node(K + i, arr[K + i]));

            // 이전 자릿수의 인덱스보다 작은 인덱스는 제거
            while (!pq.isEmpty() && pq.peek().idx < preIdx) {
                pq.poll();
            }

            preIdx = pq.peek().idx;
            sb.append(pq.poll().value);
        }

        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int idx, value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Node n) {
            if (this.value == n.value) {
                return this.idx - n.idx;
            }
            return n.value - this.value;
        }
    }
}