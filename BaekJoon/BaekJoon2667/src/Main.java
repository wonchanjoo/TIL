import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int N;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dirR = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dirC = {0, 0, -1, 1}; // 상 하 좌 우
    static int count = 0;
    static PriorityQueue<Integer> counts = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j) == '1';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        sb.append(count).append('\n');
        while(!counts.isEmpty()) {
            sb.append(counts.poll()).append('\n');
        }
        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        count++;
        int sum = 1;

        Queue<Integer[]> q = new ArrayDeque<>();
        q.offer(new Integer[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Integer[] n = q.poll();
            for(int i = 0; i < 4; i++) {
                int newR = n[0] + dirR[i];
                int newC = n[1] + dirC[i];
                if (isRight(newR, newC) && map[newR][newC] && !visited[newR][newC]) {
                    q.offer(new Integer[]{newR, newC});
                    visited[newR][newC] = true;
                    sum++;
                }
            }
        }
        counts.offer(sum);
    }

    private static boolean isRight(int r, int c) {
        return (r >= 0 && c >= 0 && r < N && c < N);
    }
}