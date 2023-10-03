import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static List<Point> cctvList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                // cctv가 있는 곳인 경우
                if (map[r][c] >= 1 && map[r][c] <= 5) {
                    cctvList.add(new Point(r, c));
                }
            }
        }

        for (int i = 0; i < cctvList.size(); i++) {
            Point cctv = cctvList.get(i);
        }
    }

    private static void dfs(int idx) {
        if (idx == cctvList.size()) {
            return;
        }

        Point cctv = cctvList.get(idx);
        if (map[cctv.r][cctv.c] == 2) {

        } else {

        }
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}