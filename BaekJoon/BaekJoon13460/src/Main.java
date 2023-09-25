import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M; // N: 세로 / M: 가로
    static char[][] map;
    static Bead red, blue;
    static int answer = Integer.MAX_VALUE;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < M; c++) {
                char ch = s.charAt(c);
                map[r][c] = ch;

                if (ch == 'B') {
                    blue = new Bead(r, c, -1);
                    map[r][c] = '.';
                } else if (ch == 'R') {
                    red = new Bead(r, c, -1);
                    map[r][c] = '.';
                }
            }
        }

        start();

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void start() {
        Deque<Bead[]> queue = new ArrayDeque<>();

        // 시작점
        for (int i = 0; i < 4; i++) {
            Bead r = new Bead(red);
            Bead b = new Bead(blue);
            r.d = b.d = i;

            boolean moveR = r.move(b);
            boolean moveB = b.move(r);
            if (moveR || moveB) {
                queue.offer(new Bead[]{r, b});
            }
        }

        while (!queue.isEmpty()) {
            Bead[] beads = queue.poll();

            // 탈출 조건
            if (beads[0].count > 10 || beads[0].count >= answer) {
                continue;
            }

            // 둘 중 하나라도 이동이 가능하면 계속 간다.
            if (beads[0].move(beads[1]) || beads[1].move(beads[0])) {
                queue.offer(Arrays.copyOf(beads, beads.length));
            }
            // 둘 다 이동할 수 없는 경우
            else {
                // 파란 구슬이 구멍에 들어간 경우
                if (beads[1].goal) {
                    continue;
                }
                // 빨간 구슬이 구멍에 들어간 경우
                if (beads[0].goal) {
                    answer = Math.min(answer, beads[0].count);
                    continue;
                }


                for (int i = 0; i < 4; i++) {
                    // 원래 방향과 왔던 길은 제외
                    if (i == beads[0].d || (i + beads[0].d == 1 || i + beads[0].d == 5)) {
                        continue;
                    }

                    Bead tmpR = new Bead(beads[0]);
                    Bead tmpB = new Bead(beads[1]);

                    tmpR.d = tmpB.d = i; // 방향 전환
                    // 둘 중 하나라도 새로운 방향으로 이동 가능한 경우
                    if (tmpR.move(tmpB) || tmpB.move(tmpR)) {
                        tmpR.count++;
                        tmpB.count++;
                        queue.offer(new Bead[]{tmpR, tmpB});
                    }
                }
            }
        }
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < M);
    }

    static class Bead {
        int r, c, d;
        int count = 1;
        boolean goal;

        public Bead(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        public Bead(Bead bead) {
            this.r = bead.r;
            this.c = bead.c;
            this.d = bead.d;
            this.count = bead.count;
        }

        private boolean move(Bead other) {
            int tmpR = this.r;
            int tmpC = this.c;

            // d 방향으로 이동
            this.r += dirR[d];
            this.c += dirC[d];

            // 이동할 수 있는 경우
            if (rangeIn(r, c) && map[r][c] != '#' && !this.equals(other)) {

                // 구멍에 들어간 경우
                if (map[r][c] == 'O') {
                    goal = true;
                    this.r = this.c = 0; // 더 이상 이동할 수 없도록
                }

                return true;
            }
            // 이동할 수 없는 경우
            else {
                this.r = tmpR;
                this.c = tmpC;
                return false;
            }
        }

        @Override
        public boolean equals(Object obj) {
            Bead bead = (Bead) obj;
            return this.r == bead.r && this.c == bead.c;
        }
    }
}