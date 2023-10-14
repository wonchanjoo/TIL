import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] power;
    static int[][] attack; // 공격한 시점
    static boolean[][] attacked;
    static List<Turret> turrets = new ArrayList<>();
    static int k; // 현재 몇번째 턴인지
    static int turretCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        power = new int[N][M];
        attack = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                power[r][c] = Integer.parseInt(st.nextToken());

                if (power[r][c] > 0) {
                    turrets.add(new Turret(r, c));
                    turretCnt++;
                }
            }
        }

        for (int i = 1; i <= K; i++) {
            if (turretCnt <= 1) {
                break;
            }

            k = i;
            start();
        }


        Collections.sort(turrets);
        Turret strong = turrets.get(turrets.size() - 1);
        System.out.println(power[strong.r][strong.c]);
    }

    private static void start() {
        attacked = new boolean[N][M];

        // 1. 공격자 선정
        Collections.sort(turrets);
        Turret weak = turrets.get(turrets.size() - turretCnt);
        power[weak.r][weak.c] += (N + M); // 공격력 증가
        attack[weak.r][weak.c] = k; // 공격한거 저장

        // 2. 공격당할 포탑 선정
        Turret strong = turrets.get(turrets.size() - 1);
        power[strong.r][strong.c] -= power[weak.r][weak.c];
        attacked[strong.r][strong.c] = true;

        // 2-1. 레이저 공격
        if (!laserAttack(weak, strong)) {
            shellAttack(weak, strong); // 2-2. 실패하면 포탄 공격
        }

        // 3. 포탑 정비
        maintain(weak);
    }

    private static boolean laserAttack(Turret weak, Turret strong) {
        // 우 하 좌 상
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        // 최단거리 구하기
        Deque<Point> queue = new ArrayDeque<>();
        int[][] backR = new int[N][M];
        int[][] backC = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        queue.offer(new Point(weak.r, weak.c));
        visited[weak.r][weak.c] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.r == strong.r && now.c == strong.c) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = (now.r + N + dr[i]) % N;
                int nextC = (now.c + M + dc[i]) % M;

                // 부서진 포탑이거나 이미 방문한 경우
                if (power[nextR][nextC] == 0 || visited[nextR][nextC]) {
                    continue;
                }

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
                backR[nextR][nextC] = now.r;
                backC[nextR][nextC] = now.c;
            }
        }

        // 레이저 공격을 할 수 없는 경우
        if (!visited[strong.r][strong.c]) {
            return false;
        }

        // 최단 경로로 공격을 진행
        int r = backR[strong.r][strong.c];
        int c = backC[strong.r][strong.c];
        while (!(r == weak.r && c == weak.c)) {
            attacked[r][c] = true;
            power[r][c] -= (power[weak.r][weak.c] / 2);

            int nextR = backR[r][c];
            int nextC = backC[r][c];

            r = nextR;
            c = nextC;
        }

        return true;
    }

    private static void shellAttack(Turret weak, Turret strong) {
        // 8개의 방향
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

        for (int i = 0; i < 8; i++) {
            int nextR = (N + strong.r + dr[i]) % N;
            int nextC = (M + strong.c + dc[i]) % M;

            // 부서진 포탑이 존재하거나 공격자인 경우
            if (power[nextR][nextC] == 0 || (nextR == weak.r && nextC == weak.c)) {
                continue;
            }

            power[nextR][nextC] -= (power[weak.r][weak.c] / 2);
            attacked[nextR][nextC] = true;
        }
    }

    private static void maintain(Turret weak) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                // 공격 받지 않은 포탑의 공격력 증가
                if (!attacked[r][c] && power[r][c] > 0 && !(r == weak.r && c == weak.c)) {
                    power[r][c]++;
                }

                // 방금 공격 받은 포탑 중 부서진 포탑이 존재하는 경우
                if (attacked[r][c] && power[r][c] <= 0) {
                    power[r][c] = 0;
                    turretCnt--;
                }
            }
        }
    }

    static class Turret implements Comparable<Turret> {
        int r, c;

        public Turret(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Turret turret) {
            if (power[this.r][this.c] == power[turret.r][turret.c]) {
                if (attack[this.r][this.c] == attack[turret.r][turret.c]) {
                    int sum1 = this.r + this.c;
                    int sum2 = turret.r + turret.c;
                    if (sum1 == sum2) {
                        return turret.c - this.c;
                    }
                    return sum2 - sum1;
                }

                return attack[turret.r][turret.c] - attack[this.r][this.c];
            }
            return power[this.r][this.c] - power[turret.r][turret.c];
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