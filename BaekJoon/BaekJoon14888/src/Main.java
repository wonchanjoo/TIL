import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A;
    static int[] operator = new int[4]; // +, -, x, /

    static int min = 1_000_000_001;
    static int max = -1_000_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, A[0]);

        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    private static void dfs(int idx, int n) {
        if (idx == N) {
            min = Math.min(min, n);
            max = Math.max(max, n);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        dfs(idx + 1, n + A[idx]);
                        break;
                    case 1:
                        dfs(idx + 1, n - A[idx]);
                        break;
                    case 2:
                        dfs(idx + 1, n * A[idx]);
                        break;
                    case 3:
                        dfs(idx + 1, n / A[idx]);
                        break;
                }
                operator[i]++;
            }
        }
    }
}