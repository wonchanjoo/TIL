import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    static int N, M;
    static int[][] map;
    static int[][] cost;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cost = new int[N][M];

        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c) - '0';
                cost[r][c] = INF;
            }
        }

        bfs();
        System.out.println(cost[N - 1][M - 1]);
    }

    private static void bfs() {
        Deque<Point> deque = new ArrayDeque<>();

        deque.offer(new Point(0, 0));
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            Point now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dirR[i];
                int nextC = now.c + dirC[i];

                if (rangeIn(nextR, nextC) && cost[nextR][nextC] > cost[now.r][now.c] + map[nextR][nextC]) {
                    cost[nextR][nextC] = cost[now.r][now.c] + map[nextR][nextC];

                    if (map[nextR][nextC] == 0) {
                        deque.offerFirst(new Point(nextR, nextC));
                    } else {
                        deque.offerLast(new Point(nextR, nextC));
                    }
                }
            }
        }
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < M);
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}