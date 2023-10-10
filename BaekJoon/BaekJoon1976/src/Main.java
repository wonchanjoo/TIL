import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        initParent();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                // i와 j가 연결된 경우
                if (st.nextToken().equals("1")) {
                    union(i, j);
                }
            }
        }

        boolean possible = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp = parent[Integer.parseInt(st.nextToken())];
        for (int i = 0; i < M - 1; i++) {
            if (tmp != parent[Integer.parseInt(st.nextToken())]) {
                possible = false;
            }
        }

        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void initParent() {
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    private static void union(int a, int b) {
        if (parent[a] == parent[b]) {
            return;
        }

        int pa = find(a);
        int pb = find(b);

        if (pa < pb) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }

    private static int find(int n) {
        if (parent[n] == n) {
            return n;
        }

        return parent[n] = find(parent[n]);
    }
}