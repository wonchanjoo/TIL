import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, C;
    static Jewelry[] jewelries;
    static int[] bag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewelries = new Jewelry[N];
        bag = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.M == o2.M) {
                    return o2.V - o1.V;
                }
                return o1.M - o2.M;
            }
        });
        Arrays.sort(bag);

        long answer = 0;
        int idx = 0;
        PriorityQueue<Jewelry> pq = new PriorityQueue<>(new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                return o2.V - o1.V;
            }
        });

        for (int i = 0; i < K; i++) {
            // 가방보다 무게가 작은 보석 우선순위큐에 삽입
            while (idx < N && jewelries[idx].M <= bag[i]) {
                pq.offer(jewelries[idx]);
                idx++;
            }

            // 큐에 보석이 있는 경우, 하나 꺼내서 가방에 넣기
            if (!pq.isEmpty()) {
                answer += pq.poll().V;
            }
        }

        System.out.println(answer);
    }

    static class Jewelry {
        int M, V;

        public Jewelry(int M, int V) {
            this.M = M;
            this.V = V;
        }
    }
}