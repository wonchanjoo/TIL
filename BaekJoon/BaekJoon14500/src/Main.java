import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] score, tetromino;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        score = new int[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                score[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        initTetromino();
    }

    private static void DFS(Point p, int sum) {
        for (int r = p.r; r < N; r++) {
            for (int c = (r == p.r) ? p.c : 0; c < M; c++) {

            }
        }
    }

    private static void initTetromino() {
        tetromino = new int[][]{
                {0, 0}, {0, 1}, {0, 2}, {0, 3},
                {0, 0}, {0, 1}, {1, 0}, {1, 1},
                {0, 0}, {1, 0}, {2, 0}, {2, 1},
                {0, 0}, {1, 0}, {1, 1}, {2, 1},
                {0, 0}, {0, 1}, {0, 2}, {1, 1}
        };
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}