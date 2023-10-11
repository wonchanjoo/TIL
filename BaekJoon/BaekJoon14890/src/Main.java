import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, L;
    static int[][] map;
    static int[][] horizontal;
    static int[][] vertical;
    static boolean[] installed;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        horizontal = new int[N][N];
        vertical = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        initCountArr();

        for (int i = 0; i < N; i++) {
            if (horizontalPass(i)) {
                answer++;
            }
            if (verticalPass(i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 높이가 같은 칸의 개수를 수평, 수직 방향으로 저장한다
    private static void initCountArr() {
        for (int r = 0; r < N; r++) {
            Point start = new Point(r, 0);
            int count = 1;

            for (int c = 1; c < N; c++) {
                if (map[r][c] != map[r][c - 1]) {
                    horizontal[r][start.c] = horizontal[r][c - 1] = count;
                    start = new Point(r, c);
                    count = 1;
                } else {
                    count++;
                }
            }

            horizontal[r][start.c] = horizontal[r][N - 1] = count;
        }

        for (int c = 0; c < N; c++) {
            Point start = new Point(0, c);
            int count = 1;

            for (int r = 1; r < N; r++) {
                if (map[r][c] != map[r - 1][c]) {
                    vertical[start.r][c] = vertical[r - 1][c] = count;
                    start = new Point(r, c);
                    count = 1;
                } else {
                    count++;
                }
            }

            vertical[start.r][c] = vertical[N - 1][c] = count;
        }
    }

    // i번째 행의 경사로 설치 가능 여부 반환
    private static boolean horizontalPass(int i) {
        installed = new boolean[N];

        for (int j = 1; j < N; j++) {
            if (map[i][j - 1] != map[i][j]) {
                // 1. 높이 차가 1이 아닌 경우
                if (Math.abs(map[i][j - 1] - map[i][j]) != 1) {
                    return false;
                }

                int min = (map[i][j - 1] < map[i][j]) ? (j - 1) : j; // 낮은 칸의 열 번호
                boolean left = map[i][j - 1] < map[i][j];

                // 2. 경사로를 설치할 칸이 부족한 병우
                if (horizontal[i][min] < L) {
                    return false;
                }

                boolean possible = installSlope(min, left);
                // 3. 이미 경사로가 설치된 경우
                if (!possible) {
                    return false;
                }
            }
        }

        return true;
    }
    // i번째 열의 경사로 설치 가능 여부 반환
    private static boolean verticalPass(int i) {
        installed = new boolean[N];

        for (int j = 1; j < N; j++) {
            if (map[j - 1][i] != map[j][i]) {
                // 1. 높이 차가 1이 아닌 경우
                if (Math.abs(map[j - 1][i] - map[j][i]) != 1) {
                    return false;
                }

                int min = (map[j - 1][i] < map[j][i]) ? (j - 1) : j; // 낮은 칸의 열 번호
                boolean left = map[j - 1][i] < map[j][i];

                // 2. 경사로를 설치할 칸이 부족한 병우
                if (vertical[min][i] < L) {
                    return false;
                }

                boolean possible = installSlope(min, left);
                // 3. 이미 경사로가 설치된 경우
                if (!possible) {
                    return false;
                }
            }
        }

        return true;
    }

    // i에서 L만큼 경사로 설치, 불가능한 경우 false 반환
    private static boolean installSlope(int i, boolean left) {
        if (left) {
            for (int j = i; j > (i - L); j--) {
                if (installed[j]) {
                    return false;
                }
                installed[j] = true;
            }
        } else {
            for (int j = i; j < (i + L); j++) {
                if (installed[j]) {
                    return false;
                }
                installed[j] = true;
            }
        }

        return true;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}