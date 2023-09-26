import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static List<Point> virus = new ArrayList<>();
    static int answer = 0;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 바이러스 위치를 리스트에 저장한다.
                if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        DFS(new Point(0, 0), 0);
        System.out.println(answer);
    }

    private static void DFS(Point p, int cnt) {
        // 3개의 벽을 모두 세운 경우
        if (cnt == 3) {
            int tmp = BFS();
            answer = Math.max(answer, tmp);
            return;
        }

        for (int i = p.r; i < N; i++) {
            for (int j = (i == p.r ? p.c : 0); j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    map[i][j] = 1;
                    DFS(new Point(i, j), cnt + 1);
                    visited[i][j] = false;
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int BFS() {
        boolean[][] infected = new boolean[N][M];
        Deque<Point> queue = new ArrayDeque<>();

        for (Point p : virus) {
            queue.offer(p);
            infected[p.r][p.c] = true;
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dirR[i];
                int nextC = now.c + dirC[i];

                if (rangeIn(nextR, nextC) && map[nextR][nextC] == 0 && !infected[nextR][nextC]) {
                    infected[nextR][nextC] = true;
                    queue.offer(new Point(nextR, nextC));
                }
            }
        }

        // 안전 구역 갯수 구하기
        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!infected[r][c] && map[r][c] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
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