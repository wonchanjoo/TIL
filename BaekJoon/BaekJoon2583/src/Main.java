import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int M, N, K, count = 0;
    static boolean[][] map;
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> answer = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[M][N];
        for(int i = 0 ; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int width = x2 - x1;
            int height = y2 - y1;

            y1 = M - y1;
            for(int r = y1 - height; r < y1; r++)
                for(int c = x1; c < width + x1; c++)
                    map[r][c] = true;
        }

        for(int r = 0; r < M; r++)
            for(int c = 0; c < N; c++)
                if(!map[r][c]) {
                    count++;
                    answer.add(dfs(r, c, 1));
                }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        Collections.sort(answer);
        for (Integer integer : answer) sb.append(integer).append(' ');
        System.out.println(sb);
    }

    private static int dfs(int r, int c, int sum) {
        map[r][c] = true;

        for(int i = 0; i < 4; i++) {
            int newR = r + dirR[i];
            int newC = c + dirC[i];
            if(rangeIn(newR, newC) && !map[newR][newC])
                sum = dfs(newR, newC, sum + 1);
        }

        return sum;
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < M) && (c < N);
    }
}