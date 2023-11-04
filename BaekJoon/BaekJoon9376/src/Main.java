import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static final char EMPTY = '.';
    static final char WALL = '*';
    static final char DOOR = '#';
    static final char USER = '$';

    static int h, w;
    static char[][] arr;
    static int[][] cost;
    static List<Point> users;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            arr = new char[h][w];
            cost = new int[h][w];
            users = new ArrayList<>();

            for (int r = 0; r < h; r++) {
                String s = br.readLine();
                for (int c = 0; c < w; c++) {
                    arr[r][c] = s.charAt(c);
                    cost[r][c] = INF;

                    if (arr[r][c] == USER) {
                        users.add(new Point(r, c));
                        arr[r][c] = EMPTY;
                    }
                }
            }

            move(0);
            move(1);

            int answer = getAnswer();
            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }

    private static void move(int idx) {
        Deque<Point> deque = new ArrayDeque<>();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Point user = users.get(idx);
        deque.offer(new Point(user.r, user.c));
        cost[user.r][user.c] = (cost[user.r][user.c] == INF) ? 0 : cost[user.r][user.c];

        while (!deque.isEmpty()) {
            Point now = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dr[i];
                int nextC = now.c + dc[i];

                if (!canMove(nextR, nextC)) {
                    continue;
                }


                if (cost[nextR][nextC] == INF) {
                    if (arr[nextR][nextC] == DOOR) {
                        cost[nextR][nextC] = cost[now.r][now.c] + 1;
                        deque.offerLast(new Point(nextR, nextC));
                    } else {
                        cost[nextR][nextC] = cost[now.r][now.c];
                        deque.offerFirst(new Point(nextR, nextC));
                    }
                }


            }
        }
    }

    private static int getAnswer() {
        int min = INF;

        for (int i = 0; i < h; i++) {
            if (arr[i][0] != WALL) {
                min = Math.min(min, cost[i][0]);
            }
            if (arr[0][i] != WALL) {
                min = Math.min(min, cost[0][i]);
            }
        }

        for (int i = 0; i < w; i++) {
            if (arr[i][0] != WALL) {
                min = Math.min(min, cost[i][0]);
            }
            if (arr[0][i] != WALL) {
                min = Math.min(min, cost[0][i]);
            }
        }

        return min;
    }

    private static boolean canMove(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < h) && (c < w) && arr[r][c] != WALL;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}