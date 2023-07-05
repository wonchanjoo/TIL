import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dirR = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dirC = {0, 0, -1, 1}; // 상 하 좌 우
    static Queue<Integer[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) // 맨 처음에 시작할 좌표들을 큐에 넣어준다.
                    q.offer(new Integer[]{i, j});
            }
        }

        int day = 0;
        while (!q.isEmpty()) {
            int r = q.peek()[0];
            int c = q.poll()[1];
            day = Math.max(visited[r][c], day);

            for(int i = 0; i < 4; i++) {
                int newR = r + dirR[i];
                int newC = c + dirC[i];

                if(isRight(newR, newC) && map[newR][newC] == 0) {
                    map[newR][newC] = 1;
                    visited[newR][newC] = visited[r][c] + 1;
                    q.offer(new Integer[]{newR, newC});
                }
            }
        }

	// 안 익은 토마토가 있는지 확인
        boolean result = true;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(map[i][j] == 0) {
                    result = false;
                    break;
                }

        if(result)
            System.out.println(day);
        else
            System.out.println(-1);
    }

    private static boolean isRight(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < M);
    }
}