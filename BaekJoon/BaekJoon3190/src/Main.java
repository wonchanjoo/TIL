import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, K, L;     // N: 보드 크기 / K: 사과 개수 / L: 뱀의 방향 변환 수
    static int[][] board;   // 1: 사과 / 2: 뱀

    // 뱀의 좌표들
    static Deque<Point> snake = new ArrayDeque<>();

    // 뱀의 이동 방향, 처음엔 오른쪽
    static int dirR = 0;
    static int dirC = 1;

    static boolean gameOver = false;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r - 1][c - 1] = 1; // 사과 위치 표시
        }

        L = Integer.parseInt(br.readLine());
        snake.offer(new Point(0, 0)); // 뱀의 처음 위치
        board[0][0] = 2;

        int before = 0;
        for (int i = 0; i < L; i++) {
            if (gameOver) {
                break;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();

            moveSnake(X - before, C);
            before = X;
        }

        // 게임이 끝나지 않은 경우 마지막 방향으로 쭉 간다
        if (!gameOver) {
            moveSnake(N, "D");
        }
        System.out.println(count);
    }

    // X 만큼 이동 후, C로 방향 전환
    private static void moveSnake(int X, String C) {
        Point head = snake.peekFirst();

        int r = head.r;
        int c = head.c;
        for (int i = 0; i < X; i++) {
            r += dirR;
            c += dirC;

            // 벽이나 자기자신의 몸과 부딪힌 경우
            if (!rangeIn(r, c) || board[r][c] == 2) {
                gameOver = true;
                return;
            }

            // 몸 길이를 늘려 준다.
            snake.offerFirst(new Point(r, c));

            // 사과가 없는 경우 꼬리를 지워준다.
            if (board[r][c] != 1) {
                Point tail = snake.pollLast();
                board[tail.r][tail.c] = 0;
            }

            board[r][c] = 2;
            count++;
        }

        // C로 방향 전환
        if (C.equals("L")) {
            if (dirR != 0) {
                dirC = dirR;
                dirR = 0;
            } else {
                dirR = -dirC;
                dirC = 0;
            }
        } else {
            if (dirR != 0) {
                dirC = -dirR;
                dirR = 0;
            } else {
                dirR = dirC;
                dirC = 0;
            }
        }
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < N);
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
