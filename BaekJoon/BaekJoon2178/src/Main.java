import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static boolean visited[][];
    static int map[][];
    static int count[][];
    static int dirR[] = {1, -1, 0, 0}; // 동 서 남 북
    static int dirC[] = {0, 0, 1, -1}; // 동 서 남 북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        count = new int[N][M];
        for(int r = 0; r < N; r++) {
            String s = br.readLine();
            for(int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c) - '0';
            }
        }

        countPath();
        System.out.println(count[N - 1][M - 1]);
    }

    private static void countPath() {
        Queue<Integer[]> q = new ArrayDeque<>();
        count[0][0] = 1;
        visited[0][0] = true;
        q.offer(new Integer[]{0, 0});

        while(!q.isEmpty()) {
            Integer[] n = q.poll();
            for(int i = 0; i < 4; i++) { // 동서남북 중 아직 방문하지 않은 노드
                int newR = n[0] + dirR[i];
                int newC = n[1] + dirC[i];
                if(isRight(newR, newC) && map[newR][newC] == 1 && !visited[newR][newC]) {
                    q.offer(new Integer[]{newR, newC});
                    count[newR][newC] = count[n[0]][n[1]] + 1;
                    visited[newR][newC] = true;
                }
            }
        }
    }

    private static boolean isRight(int r, int c) {
        return (r >= 0 && c >= 0 && r < N && c < M);
    }
}
