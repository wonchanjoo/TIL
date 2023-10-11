import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H;
    static int[][] ladder; // 0: 빈 칸 / 1: 왼쪽으로 / 2: 오른쪽으로
    static int answer = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = 2;
            ladder[a][b + 1] = 1;
        }

        dfs(1, 1, 0);

        if (answer == 4) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void dfs(int r, int c, int cnt) {
        if (pass()) {
            answer = Math.min(answer, cnt);
            return;
        }

        // 정답이 3보다 크거나, 최솟값보다 큰 경우
        if (cnt >= 3 || cnt >= answer) {
            return;
        }

        for (int i = r; i <= H; i++) {
            for (int j = (i == r) ? c : 1; j < N; j++) {
                if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                    ladder[i][j] = 2;
                    ladder[i][j + 1] = 1;
                    dfs(i, j, cnt + 1);
                    ladder[i][j] = ladder[i][j + 1] = 0; // 원상 복구
                }
            }
        }
    }

    // i번의 세로선의 결과가 i번이 나오는지 확인
    private static boolean pass() {
        for (int c = 1; c <= N; c++) {
            Deque<Point> queue = new ArrayDeque<>();
            queue.offer(new Point(1, c));

            while (true) {
                if (queue.peek().r > H) {
                    break;
                }
                Point now = queue.poll();

                switch (ladder[now.r][now.c]) {
                    case 0:
                        queue.offer(new Point(now.r + 1, now.c));
                        break;
                    case 1:
                        queue.offer(new Point(now.r + 1, now.c - 1));
                        break;
                    case 2:
                        queue.offer(new Point(now.r + 1, now.c + 1));
                        break;
                }
            }

            if (queue.poll().c != c) {
                return false;
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