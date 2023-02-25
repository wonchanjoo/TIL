import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] S = new int[N + 1][N + 1];

        for(int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= N; c++)
                S[r][c] = S[r - 1][c] + S[r][c - 1] - S[r - 1][c - 1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 - 1] + S[x1 - 1][y1 - 1] + "\n");
        }

        System.out.println(sb.toString());
    }

}
