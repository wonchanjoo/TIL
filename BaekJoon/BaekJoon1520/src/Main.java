import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];
        dp = new int[M][N];

        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        initVisited();
        dp[0][0] = 1;
        System.out.println(getCount(M - 1, N - 1));
    }

    // (0, 0)부터 갈 수 있는 길에 표시
    private static void initVisited() {
        Deque<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dirR[i];
                int nextC = now.c + dirC[i];

                if (rangeIn(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] < map[now.r][now.c]) {
                    visited[nextR][nextC] = true;
                    queue.offer(new Point(nextR, nextC));
                }
            }
        }
    }

    // (r, c)까지 내리막길로만 이동하는 경로의 개수
    private static int getCount(int r, int c) {
        if (dp[r][c] > 0) {
            return dp[r][c];
        }

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dirR[i];
            int nextC = c + dirC[i];

            if (rangeIn(nextR, nextC) && visited[nextR][nextC] && map[nextR][nextC] > map[r][c]) {
                sum += getCount(nextR, nextC);
            }
        }

        return dp[r][c] = sum;
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < M) && (c < N);
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}