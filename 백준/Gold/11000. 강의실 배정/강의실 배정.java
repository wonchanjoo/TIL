import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static PriorityQueue<Class> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> rooms = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            pq.offer(new Class(S, T));
        }

        rooms.offer(pq.poll().T); // 첫 번째 강의가 끝나는 시간
        while (!pq.isEmpty()) {
            Class c = pq.poll();

            if (rooms.peek() <= c.S) {
                rooms.poll();
            }

            rooms.offer(c.T);
        }

        System.out.println(rooms.size());
    }

    static class Class implements Comparable<Class> {
        int S, T;

        public Class(int S, int T) {
            this.S = S;
            this.T = T;
        }

        @Override
        public int compareTo(Class c) {
            if (this.S == c.S) {
                return this.T - c.T;
            }

            return this.S - c.S;
        }
    }
}