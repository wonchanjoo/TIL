import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static int R, C, T;
    static int[][] dust;
    static Point airCleaner; // (r, c) (r + 1, c)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        dust = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                dust[r][c] = Integer.parseInt(st.nextToken());

                if (dust[r][c] == -1 && airCleaner == null) {
                    airCleaner = new Point(r, c);
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spreadDust();
            airCleanerOperation();
        }

        int answer = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (dust[r][c] > 0) {
                    answer += dust[r][c];
                }
            }
        }
        System.out.println(answer);
    }

    private static void spreadDust() {
        int[][] newDust = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                newDust[r][c] += dust[r][c];

                if (dust[r][c] > 0) {
                    int cnt = 0;
                    // 인접한 네 방향으로 미세먼지가 확산된다.
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];

                        // 공기청정기가 없는 유효한 칸에만 확산이 일어난다.
                        if (rangeIn(nr, nc) && dust[nr][nc] != -1) {
                            newDust[nr][nc] += (dust[r][c] / 5);
                            cnt++;
                        }
                    }

                    // 남은 미세먼지 양을 계산한다.
                    newDust[r][c] -= (cnt * (dust[r][c] / 5));
                }
            }
        }

        // dust에 newDust 복사
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                dust[r][c] = newDust[r][c];
            }
        }
    }

    private static void airCleanerOperation() {
        int r, c;

        // 반시계방향 순환
        r = airCleaner.r - 1;
        c = 0;
        while (r != 0) {
            dust[r][c] = dust[--r][c];
        }
        while (c != (C - 1)) {
            dust[r][c] = dust[r][++c];
        }
        while (r != airCleaner.r) {
            dust[r][c] = dust[++r][c];
        }
        while (c != 1) {
            dust[r][c] = dust[r][--c];
        }
        dust[r][c] = 0;

        // 시계방향 순환
        r = airCleaner.r + 2;
        c = 0;
        while (r != (R - 1)) {
            dust[r][c] = dust[++r][c];
        }
        while (c != (C - 1)) {
            dust[r][c] = dust[r][++c];
        }
        while (r != (airCleaner.r + 1)) {
            dust[r][c] = dust[--r][c];
        }
        while (c != 1) {
            dust[r][c] = dust[r][--c];
        }
        dust[r][c] = 0;
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < R) && (c < C);
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}