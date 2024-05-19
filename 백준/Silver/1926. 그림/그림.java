import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int count = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (arr[r][c] == 1 && !visited[r][c]) {
                    count++;
                    bfs(r, c);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    private static void bfs(int r, int c) {
        int area = 0;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            area++;

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dr[i];
                int nextC = now.c + dc[i];

                if (rangeIn(nextR, nextC) && arr[nextR][nextC] == 1 && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.offer(new Node(nextR, nextC));
                }
            }
        }

        max = Math.max(max, area);
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (r < n) && (c >= 0) && (c < m);
    }

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}