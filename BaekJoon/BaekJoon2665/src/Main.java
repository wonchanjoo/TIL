import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static final int BLACK = 0;
    static final int WHITE = 1;

    static int n;
    static int[][] board;
    static int[][] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        cnt = new int[n][n];

        for (int r = 0; r < n; r++) {
            String s = br.readLine();
            for (int c = 0; c < n; c++) {
                board[r][c] = s.charAt(c) - '0';
                cnt[r][c] = INF;
            }
        }

        solve();
        System.out.println(cnt[n - 1][n - 1]);
    }

    private static void solve() {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Deque<Point> deque = new ArrayDeque<>();

        deque.offer(new Point(0, 0));
        cnt[0][0] = 0;

        while (!deque.isEmpty()) {
            Point now = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dr[i];
                int nextC = now.c + dc[i];

                if (!rangeIn(nextR, nextC)) {
                    continue;
                }

                int tmp = (board[nextR][nextC] == BLACK) ? cnt[now.r][now.c] + 1 : cnt[now.r][now.c];
                if (tmp < cnt[nextR][nextC]) {
                    cnt[nextR][nextC] = tmp;

                    if (board[nextR][nextC] == WHITE) {
                        deque.offerFirst(new Point(nextR, nextC));
                    } else {
                        deque.offerLast(new Point(nextR, nextC));
                    }
                }
            }
        }
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < n) && (c < n);
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}