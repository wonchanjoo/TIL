import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int answer = 0;
    static int shark = 0;
    static int babyShark = 0;

    static int[][] map;
    static boolean[][] eat;
    static Point start;

    static int[] dirR = {0, -1, 0, 1};
    static int[] dirC = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        eat = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                if (map[r][c] == 9) {
                    start = new Point(r, c, 2, 0);
                } else if (map[r][c] > 0) {
                    shark++;
                }
            }
        }

        start();

        System.out.println(answer);
    }

    private static void start() {
        Deque<Point> queue = new ArrayDeque<>();

        // 시작점 설정
        queue.offer(start);
        eat[start.r][start.c] = true;

        while (!queue.isEmpty()) {
            // 더 이상 먹을 수 있는 물고기가 없는 경우
            if (shark <= 0) {
                break;
            }

            Point now = queue.poll();
            answer = now.time;

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dirR[i];
                int nextC = now.c + dirC[i];

                if(rangeIn(nextR, nextC) && !eat[nextR][nextC]) {
                    if (map[nextR][nextC] < map[now.r][now.c]) {
                        // 나보다 크기가 작은 물고기인 경우
                        if (map[nextR][nextC] > 0) {
                            shark--;
                            babyShark++;

                            if (babyShark == now.size) {
                                queue.offer(new Point(nextR, nextC, now.size + 1, now.time + 1));
                            } else {
                                queue.offer(new Point(nextR, nextC, now.size, now.time + 1));
                            }
                        }
                        // 빈 칸인 경우
                        else {
                            queue.offer(new Point(nextR, nextC, now.size, now.time + 1));
                        }
                    }
                }
            }
        }
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < N);
    }
    static class Point {
        int r, c, size, time;

        public Point(int r, int c, int size, int time) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.time = time;
        }
    }
}
