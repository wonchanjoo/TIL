import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static Lump[] lumps;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lumps = new Lump[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lumps[i] = new Lump(weight, cost);
        }

        Arrays.sort(lumps);
        for (int i = 1; i < N; i++) {
            lumps[i].weight += lumps[i - 1].weight;

            for (int j = i + 1; j < N; j++) {
                if (lumps[j].cost > lumps[i].cost) {
                    break;
                }

                lumps[i].weight += lumps[j].weight;
            }
        }

        DFS(0, 0, 0);
        System.out.println(answer);
    }

    private static void DFS(int idx, int weight, int cost) {
        if (cost >= answer) {
            return;
        }

        if (weight >= M) {
            answer = cost;
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i + 1, weight + lumps[i].weight, cost + lumps[i].cost);
                visited[i] = false;
            }
        }
    }

    static class Lump implements Comparable<Lump> {
        int weight, cost;

        public Lump(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public int compareTo(Lump lump) {
            return this.cost - lump.cost;
        }
    }
}