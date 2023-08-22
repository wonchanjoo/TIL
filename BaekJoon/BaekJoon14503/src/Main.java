import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M, d;
    static Point start;
    static int[][] room; // 0: 빈 칸 / 1: 벽 / 2: 청소 완료

    static int[] dirR = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dirC = {0, 1, 0, -1}; // 북 동 남 서

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        d = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                room[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        cleaning();

        System.out.println(answer);
    }

    private static void cleaning() {
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (room[now.r][now.c] == 0) {
                room[now.r][now.c] = 2;
                answer++;
            }

            // 현재 칸의 주변 4칸이 모두 청소 됐는지 체크
            boolean allClean = true;

            for (int i = 0; i < 4; i++) {
                // 반시계 방향으로 회전
                d = (d - 1) < 0 ? 3 : (d - 1);

                // 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
                int r = now.r + dirR[d];
                int c = now.c + dirC[d];

                if (rangeIn(r, c) && room[r][c] == 0) {
                    queue.offer(new Point(r, c));
                    allClean = false;
                    break;
                }
            }

            // 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (allClean) {
                // 한 칸 후진한 위치
                int r = now.r + dirR[d] * -1;
                int c = now.c + dirC[d] * -1;

                // 후진할 수 없는 경우 작동을 멈춘다.
                if (!rangeIn(r, c) || room[r][c] == 1) {
                    break;
                } else {
                    queue.offer(new Point(r, c));
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