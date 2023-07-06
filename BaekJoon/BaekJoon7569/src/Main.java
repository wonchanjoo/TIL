import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N, H;
    static int[][][] grid;
    static int[][][] visited;
    static Queue<Integer[]> q = new LinkedList<>();
    static int[] dirX = {0, 0, 0, 0, 1, -1}; // 위 아래 왼쪽 오른쪽 앞 뒤
    static int[] dirY = {0, 0, -1, 1, 0, 0};
    static int[] dirZ = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        grid = new int[N][M][H];
        visited = new int[N][M][H];
        int k = 0;
        for(int i = 0; i < N * H; i++) {
            if(i != 0 && i % N == 0)
                k++;

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                grid[i % N][j][k] = Integer.parseInt(st.nextToken());
                if(grid[i % N][j][k] == 1) // 맨 처음에 시작할 좌표
                    q.offer(new Integer[]{i % N, j, k});
            }
        } // 입력 값 정리 끝

        // 모든 토마토가 익어있는지 확인
        boolean all = true;
        for(int x = 0; x < N; x++)
            for(int y = 0; y < M; y++)
                for(int z = 0; z < H; z++)
                    if(grid[x][y][z] == 0) {
                        all = false;
                        y = M; x = N;
                        break;
                    }

        if(all) {
            System.out.println(0);
            return;
        }

        // 모든 토마토가 익어있지 않는 경우
        int x = 0, y = 0, z = 0;
        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            z = q.poll()[2];

            for(int i = 0; i < 6; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];
                int newZ = z + dirZ[i];

                if(isRight(newX, newY, newZ) && grid[newX][newY][newZ] == 0) {
                    q.offer(new Integer[]{newX, newY, newZ});
                    grid[newX][newY][newZ] = 1;
                    visited[newX][newY][newZ] = visited[x][y][z] + 1;
                }
            }
        }

        // 모두 익었는지 확인
        all = true;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                for(k = 0; k < H; k++)
                    if(grid[i][j][k] == 0) {
                        all = false;
                        y = M; x = N;
                        break;
                    }
        if(all)
            System.out.println(visited[x][y][z]);
        else
            System.out.println(-1);
    }

    private static boolean isRight(int x, int y, int z) {
        return (x >= 0) && (y >= 0) && (z >= 0) && (x < N) && (y < M) && (z < H);
    }
}