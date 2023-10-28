import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static final int BLACK = 0;
    static final int WHITE = 1;

    static int n;
    static int[][] board;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int r = 0; r < n; r++) {
            String s = br.readLine();
            for (int c = 0; c < n; c++) {
                board[r][c] = s.charAt(c) - '0';
            }
        }

        if (pass()) {
            System.out.println(0);
            return;
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == BLACK) {
                    board[r][c] = WHITE;
                    dfs(r, c, 1);
                    board[r][c] = BLACK;
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int r, int c, int cnt) {
        if (cnt >= answer) {
            return;
        }

        if (pass()) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = r; i < n; i++) {
            for (int j = (i == r) ? c : 0; j < n; j++) {
                if (board[i][j] == BLACK) {
                    board[i][j] = WHITE;
                    dfs(i, j, cnt + 1);
                    board[i][j] = BLACK;
                }
            }
        }
    }

    private static boolean pass() {
        Deque<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        int[] dirR = {-1, 1, 0, 0};
        int[] dirC = {0, 0, -1, 1};

        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.r == (n - 1) && now.c == (n - 1)) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dirR[i];
                int nextC = now.c + dirC[i];

                if (rangeIn(nextR, nextC) && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.offer(new Point(nextR, nextC));
                }
            }
        }

        return visited[n - 1][n - 1];
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