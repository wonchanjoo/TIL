import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static final int EXIT = -1;

    static int N, M, K;
    static int[][] map;
    static List<Point> users = new ArrayList<>();
    static Point exit;
    static int sum = 0;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            users.add(new Point(r, c));
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        exit = new Point(r, c);
        map[exit.r][exit.c] = EXIT;

        for (int i = 1; i <= K; i++) {
            // K초 전에 모든 참가자가 탈출한 경우
            if (users.size() == 0) {
                break;
            }
            start();
        }

        sb.append(sum).append('\n');
        sb.append(exit.r).append(' ').append(exit.c);
        System.out.println(sb);
    }

    private static void start() {
        // 1. 각 참가자마다 이동한다.
        moveUsers();

        if (users.size() == 0) {
            return;
        }

        // 2. 정사각형을 찾아서 회전한다.
        mazeRotate();
    }

    private static void moveUsers() {
        Deque<Integer> success = new ArrayDeque<>();

        for (int i = 0; i < users.size(); i++) {
            PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    int d1 = Math.abs(o1.r - exit.r) + Math.abs(o1.c - exit.c);
                    int d2 = Math.abs(o2.r - exit.r) + Math.abs(o2.c - exit.c);

                    if (d1 != d2) {
                        return d1 - d2;
                    }

                    // 거리가 같다면 d 값이 0이거나 1인 경우 우선순위를 높게 부여
                    if (o1.d == 0 || o1.d == 1) {
                        return -1;
                    } else if (o2.d == 0 || o2.d == 1) {
                        return 1;
                    }

                    return 0;
                }
            });

            Point user = users.get(i);
            int nowD = Math.abs(user.r - exit.r) + Math.abs(user.c - exit.c);

            // 상하좌우 중 갈 수 있는 좌표를 모두 큐에 넣는다.
            for (int j = 0; j < 4; j++) {
                int nextR = user.r + dirR[j];
                int nextC = user.c + dirC[j];
                int nextD = Math.abs(nextR - exit.r) + Math.abs(nextC - exit.c);

                if (rangeIn(nextR, nextC) && (nextD < nowD) && (map[nextR][nextC] == 0 || map[nextR][nextC] == EXIT)) {
                    pq.offer(new Point(nextR, nextC, j));
                }
            }

            if (pq.isEmpty()) {
                continue;
            }

            Point next = pq.poll();
            user.r = next.r;
            user.c = next.c;
            sum++;

            // 미로를 탈출한 경우
            if (map[user.r][user.c] == EXIT) {
                success.offer(i);
            }
        }

        // 탈출한 사람들 리스트에서 제거
        while (!success.isEmpty()) {
            users.remove(success.pollLast().intValue());
        }
    }

    // 정사각형을 찾아서 회전
    private static void mazeRotate() {

        // 정사각형 구하기
        for (int length = 2; length <= N; length++) {
            for (int r = 1; r <= (N - length + 1); r++) {
                for (int c = 1; c <= (N - length + 1); c++) {
                    // 출구가 정사각형에 포함되지 않는 경우
                    if (!(exit.r >= r && exit.r < r + length) || !(exit.c >= c && exit.c < c + length)) {
                        continue;
                    }

                    for (Point user: users) {
                        if ((user.r >= r && user.r < r + length) && (user.c >= c && user.c < c + length)) {
                            rotate(new Point(r, c), length);
                            return;
                        }
                    }
                }
            }
        }
    }

    // (start.r, start.c) ~ (start.r + n, start.c + n) 구역을 시계 방향으로 회전
    private static void rotate(Point start, int n) {
        int[][] tmp = new int[N + 1][N + 1];

        int c = start.c;
        for (int i = start.r; i < (start.r + n); i++) {
            int r = start.r + n - 1;
            for (int j = start.c; j < (start.c + n); j++) {
                tmp[i][j] = map[r][c];
                r--;
            }
            c++;
        }

        // 미로에 포함되어 있는 유저 위치 회전
        for (Point user: users) {
            if (user.r >= start.r && user.r < (start.r + n) && user.c >= start.c && user.c < (start.c + n)) {
                // 정사각형의 상대적인 위치
                int tmpR = user.r - start.r;
                int tmpC = user.c - start.c;

                user.r = start.r + tmpC;
                user.c = start.c + n - 1 - tmpR;
            }
        }

        // 원본 배열에 복사
        for (int i = start.r; i < (start.r + n); i++) {
            for (int j = start.c; j < (start.c + n); j++) {
                map[i][j] = tmp[i][j];

                // 출구 위치 변경
                if (map[i][j] == EXIT) {
                    exit.r = i;
                    exit.c = j;
                }

                // 내구도 감소
                if (map[i][j] > 0) {
                    map[i][j]--;
                }
            }
        }
    }

    private static boolean rangeIn(int r, int c) {
        return (r > 0) && (c > 0) && (r <= N) && (c <= N);
    }

    static class Point {
        int r, c, d;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}