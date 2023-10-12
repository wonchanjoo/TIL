import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static boolean[][] grid = new boolean[101][101];

    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragon(x, y, d, g);
        }

        System.out.println(count());
    }

    private static void dragon(int x, int y, int d, int g) {
        // 0 세대
        grid[y][x] = true;
        x += dirX[d];
        y += dirY[d];
        grid[y][x] = true;

        Point end = new Point(x, y); // 전 세대의 끝 점
        List<Integer> path = new ArrayList<>();
        path.add(d);

        for (int i = 1; i <= g; i++) {
            Point now = new Point(end.x, end.y);
            int size = path.size();

            for (int j = size - 1; j >= 0; j--) {
                int direction = path.get(j);
                switch (direction) {
                    case 0:
                        direction = 1;
                        break;
                    case 1:
                        direction = 2;
                        break;
                    case 2:
                        direction = 3;
                        break;
                    case 3:
                        direction = 0;
                        break;
                }
                path.add(direction);

                int nextX = now.x + dirX[direction];
                int nextY = now.y + dirY[direction];
                grid[nextY][nextX] = true;
                now = new Point(nextX, nextY);
            }

            end = new Point(now.x, now.y);
        }
    }

    private static int count() {
        int cnt = 0;

        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                if (grid[r][c] && grid[r + 1][c] && grid[r][c + 1] && grid[r + 1][c + 1]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}