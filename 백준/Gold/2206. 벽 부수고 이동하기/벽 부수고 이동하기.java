import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N, M;
    static boolean[][] map;
    static int[][][] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][M + 1];
        count = new int[N + 1][M + 1][2];

        for (int r = 1; r <= N; r++) {
            String s = br.readLine();
            for (int c = 1; c <= M; c++) {
                map[r][c] = (s.charAt(c - 1) == '0');
            }
        }

        bfs();

        count[N][M][0] = (count[N][M][0] == 0) ? Integer.MAX_VALUE : count[N][M][0];
        count[N][M][1] = (count[N][M][1] == 0) ? Integer.MAX_VALUE : count[N][M][1];
        if (count[N][M][0] == Integer.MAX_VALUE && count[N][M][1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(count[N][M][0], count[N][M][1]));
        }
    }

    private static void bfs() {
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(1, 1, 0));
        count[1][1][0] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dr[i];
                int nextC = now.c + dc[i];

                if (!rangeIn(nextR, nextC)) {
                    continue;
                }

                // 1. 벽 부수지 않고 이동 가능한 경우
                if (map[nextR][nextC] && count[nextR][nextC][now.breakWall] == 0) {
                    count[nextR][nextC][now.breakWall] = count[now.r][now.c][now.breakWall] + 1;
                    queue.offer(new Point(nextR, nextC, now.breakWall));
                }
                // 2. 벽 부수고 이동 가능한 경우
                else if (now.breakWall == 0 && !map[nextR][nextC] && count[nextR][nextC][now.breakWall] == 0) {
                    count[nextR][nextC][1] = count[now.r][now.c][now.breakWall] + 1;
                    queue.offer(new Point(nextR, nextC, 1));
                }
            }
        }
    }

    private static boolean rangeIn(int r, int c) {
        return (r > 0) && (c > 0) && (r <= N) && (c <= M);
    }

    static class Point {
        int r, c, breakWall;

        public Point(int r, int c, int breakWall) {
            this.r = r;
            this.c = c;
            this.breakWall = breakWall;
        }
    }
}