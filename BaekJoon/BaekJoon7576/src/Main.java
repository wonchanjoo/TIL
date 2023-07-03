import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1인 모~든 지점에서 같이 상하좌우 익혀야됨.
하나의 점에서 시작하는게 아님
 */
public class Main {

    static int N, M, count;
    static int[][] map;
    static int[][] visited;
    static int[] dirR = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dirC = {0, 0, -1, 1}; // 상 하 좌 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1)
                    bfs(i, j);

            }
        }
        print();
        // 전부 다 익었는지 판단
        boolean result = true;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(map[i][j] == 0) {
                    result = false;
                    i = N;
                    break;
                }

        if(result)
            System.out.println(count);
        else
            System.out.println(-1);
    }

    // map[r][c]의 상하좌우를 익힌 토마토로 바꾼다
    private static void bfs(int r, int c) {
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{r, c});
        map[r][c] = 1;

        while(!q.isEmpty()) {
            Integer[] old = q.poll();
            int oldR = old[0];
            int oldC = old[1];
            count = visited[oldR][oldC];

            // 상하좌우에 안 익은 것이 있는 경우
            for (int i = 0; i < 4; i++) {
                int newR = oldR + dirR[i];
                int newC = oldC + dirC[i];
                if (isRight(newR, newC) && visited[newR][newC] == 0 && map[newR][newC] == 0) {
                    visited[newR][newC] = visited[oldR][oldC] + 1;
                    map[newR][newC] = 1;
                    q.offer(new Integer[]{newR, newC});
                }
            }
        }
    }

    private static boolean isRight(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < M);
    }

    private static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                System.out.print(visited[i][j] + " ");
            System.out.println();
        }
    }
}