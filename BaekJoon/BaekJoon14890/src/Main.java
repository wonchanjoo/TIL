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
            if (pass(i, 0, 0)) {
                answer++;
            }
            if (pass(0, i, 1)) {
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

    // (r, c)에서 direction 방향으로 지나갈 수 있는지
    private static boolean pass(int r, int c, int direction) {
        installed = new boolean[N];

        if (direction == 0) {
            for (int i = c + 1; i < N; i++) {
                if (map[r][i - 1] != map[r][i]) {
                    // 1. 높이 차가 1이 아닌 경우
                    if (Math.abs(map[r][i - 1] - map[r][i]) != 1) {
                        return false;
                    }

                    int minC = (map[r][i - 1] < map[r][i]) ? (i - 1) : i; // 낮은 칸의 인덱스
                    boolean left = (map[r][i - 1] < map[r][i]) ? true : false;

                    // 2. 경사로를 설치할 칸이 부족한 경우
                    if (horizontal[r][minC] < L) {
                        return false;
                    }

                    boolean possible = installSlope(minC, left);

                    // 3. 이미 경사로가 설치된 경우
                    if (!possible) {
                        return false;
                    }
                }
            }
        }
        else {
            for (int i = r + 1; i < N; i++) {
                if (map[i - 1][c] != map[i][c]) {
                    if (Math.abs(map[i - 1][c] - map[i][c]) != 1) {
                        return false;
                    }

                    int minR = (map[i - 1][c] < map[i][c]) ? (i - 1) : i; // 낮은 칸의 인덱스
                    boolean left = (map[i - 1][c] < map[i][c]) ? true : false;

                    if (vertical[minR][c] < L) {
                        return false;
                    }

                    boolean possible = installSlope(minR, left);

                    if (!possible) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

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