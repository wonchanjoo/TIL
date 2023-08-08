import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = new int[6]; // 위 북 동 서 남 아래

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1: // 동
                    if ((y + 1) < M) {
                        east(x, ++y);
                        sb.append(dice[0]).append('\n');
                    }
                    break;
                case 2: // 서
                    if ((y - 1) >= 0) {
                        west(x, --y);
                        sb.append(dice[0]).append('\n');
                    }
                    break;
                case 3: // 북
                    if ((x - 1) >= 0) {
                        north(--x, y);
                        sb.append(dice[0]).append('\n');
                    }
                    break;
                case 4: // 남
                    if ((x + 1) < N) {
                        south(++x, y);
                        sb.append(dice[0]).append('\n');
                    }
                    break;
            }
        }

        System.out.println(sb);
    }

    private static void east(int x, int y) {
        int tmp = dice[2]; // 동쪽 값 저장
        dice[2] = dice[0]; // 위 -> 동쪽
        dice[0] = dice[3]; // 서쪽 -> 위
        dice[3] = dice[5]; // 아래 -> 서쪽
        dice[5] = tmp;     // 동쪽 -> 아래

        copy(x, y);
    }

    private static void west(int x, int y) {
        int tmp = dice[3]; // 서쪽 값 저장
        dice[3] = dice[0]; // 위 -> 서쪽
        dice[0] = dice[2]; // 동쪽 -> 위
        dice[2] = dice[5]; // 아래 -> 동쪽
        dice[5] = tmp;

        copy(x, y);
    }

    private static void north(int x, int y) {
        int tmp = dice[1]; // 북쪽 값 저장
        dice[1] = dice[0]; // 위 -> 북쪽
        dice[0] = dice[4]; // 남쪽 -> 위
        dice[4] = dice[5]; // 아래 -> 남쪽
        dice[5] = tmp;

        copy(x, y);
    }

    private static void south(int x, int y) {
        int tmp = dice[4]; // 남쪽 값 저장
        dice[4] = dice[0]; // 위 -> 남쪽
        dice[0] = dice[1]; // 북쪽 -> 위
        dice[1] = dice[5]; // 아래 -> 북쪽
        dice[5] = tmp;

        copy(x, y);
    }

    private static void copy(int x, int y) {
        if (map[x][y] == 0) {
            map[x][y] = dice[5];
        } else {
            dice[5] = map[x][y];
            map[x][y] = 0;
        }
    }
}