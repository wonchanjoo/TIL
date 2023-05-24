import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dirR = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dirC = {0, 0, -1, 1}; // 상 하 좌 우
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int maxValue = -1;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > maxValue)
                    maxValue = map[i][j];
            }
        }

        for(int i = 0; i < maxValue; i++) {
            initVisited();
            int c = getSafeAreaCount(i);
            if(c > max) {
                max = c;
            }
        }

        System.out.println(max);
    }

    private static int getSafeAreaCount(int rain) {
        int count = 0;
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++) {
                if(!visited[r][c] && map[r][c] > rain) {
                    dfs(r, c, rain);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int r, int c, int rain) {
        visited[r][c] = true;

        for(int i = 0; i < 4; i++) {
            int newR = r + dirR[i];
            int newC = c + dirC[i];
            if(isRightRange(newR, newC) && !visited[newR][newC] && map[newR][newC] > rain) {
                dfs(newR, newC, rain);
            }
        }
    }

    private static boolean isRightRange(int r, int c) {
        return (r >= 0 && c >= 0 && r < N && c < N);
    }

    private static void initVisited() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }
}