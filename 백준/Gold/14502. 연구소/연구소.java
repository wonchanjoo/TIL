import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static int answer = 0;
    static int[][] map;
    static List<Node> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                if (map[r][c] == 2) {
                    virus.add(new Node(r, c));
                }
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int r, int c, int cnt) {
        if (cnt == 3) {
            answer = Math.max(answer, getSafeAreaSize());
            return;
        }

        for (int i = r; i < N; i++) {
            for (int j = (i == r) ? c : 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(i, j, cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int getSafeAreaSize() {
        Deque<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        // 1. 바이러스 퍼트리기
        for (Node node : virus) {
            queue.offer(node);
            while (!queue.isEmpty()) {
                Node now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextR = now.r + dr[j];
                    int nextC = now.c + dc[j];
                    if (rangeIn(nextR, nextC) && map[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        queue.offer(new Node(nextR, nextC));
                    }
                }
            }
        }

        // 2. 안전구역 크기 계산
        int size = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c] && map[r][c] == 0) {
                    size++;
                }
            }
        }

        return size;
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (r < N) && (c >= 0) && (c < M);
    }

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}