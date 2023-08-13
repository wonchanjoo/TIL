import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] board;
    static Point R, B;
    static int answer = 11;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < M; c++) {
                board[r][c] = s.charAt(c);

                if (board[r][c] == 'R') {
                    R = new Point(r, c, false);
                    board[r][c] = '.';
                }
                if (board[r][c] == 'B') {
                    B = new Point(r, c, false);
                    board[r][c] = '.';
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            Point nextRed = new Point(R.r + dirR[i], R.c + dirC[i], false);
            Point nextBlue = new Point(B.r + dirR[i], B.c + dirC[i], false);

            if (board[nextRed.r][nextRed.c] != '#') {
                dfs(nextRed, nextBlue, i, 1);
            }
        }

        if (answer == 11)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    private static void dfs(Point red, Point blue, int dirIdx, int count) {
        // 파란 구슬만 끝까지 간 경우 그대로 머물도록
        if (board[blue.r][blue.c] == '#') {
            blue.r -= dirR[dirIdx];
            blue.c -= dirC[dirIdx];
        }

        // 탈출 조건
        if (count > 10 || ((!red.goal && !blue.goal) && red.r == blue.r && red.c == blue.c)) {
            return;
        }

        // 빨간 구슬이 구멍에 들어간 경우
        if (board[red.r][red.c] == 'O') {
            red.goal = true;
        }
        // 파란 구슬이 구멍에 들어간 경우
        if (board[blue.r][blue.c] == 'O') {
            blue.goal = true;
        }

        // 다음 칸으로 이동
        Point nextRed = new Point(red.r + dirR[dirIdx], red.c + dirC[dirIdx], red.goal);
        Point nextBlue = new Point(blue.r + dirR[dirIdx], blue.c + dirC[dirIdx], blue.goal);

        if (rangeIn(nextRed.r, nextRed.c) && board[nextRed.r][nextRed.c] != '#') {
            dfs(nextRed, nextBlue, dirIdx, count);
        }
        // 끝까지 이동한 경우
        else {
            if (red.goal) {
                if (blue.goal) {
                    return;
                } else {
                    answer = Math.min(answer, count);
                    return;
                }
            }
            for (int i = 0; i < 4; i++) {
                nextRed = new Point(red.r + dirR[i], red.c + dirC[i], red.goal);
                nextBlue = new Point(blue.r + dirR[i], blue.c + dirC[i], blue.goal);

                if (rangeIn(nextRed.r, nextRed.c) && board[nextRed.r][nextRed.c] != '#') {
                    dfs(nextRed, nextBlue, i, count + 1);
                }
            }
        }
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < M);
    }

    static class Point {
        int r, c;
        boolean goal = false;

        public Point(int r, int c, boolean goal) {
            this.r = r;
            this.c = c;
            this.goal = goal;
        }
    }
}
