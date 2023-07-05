import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dirR = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dirC = {0, 0, -1, 1}; // 상 하 좌 우
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        visited = new boolean[N][N];
        for(int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < N; c++)
                grid[r][c] = s.charAt(c);
        }

        // 적록색약이 아닌 사람이 봤을 때
        for(int r = 0; r < N; r++)
            for(int c = 0; c < N; c++)
                if(!visited[r][c]) {
                    dfs1(r, c);
                    count++;
                }

        // visited 배열, count 초기화
        sb.append(count).append(' ');
        for(int r = 0; r < N; r++)
            for(int c = 0; c < N; c++)
                visited[r][c] = false;
        count = 0;

        // 적록색약인 사람이 봤을 때
        for(int r = 0; r < N; r++)
            for(int c = 0; c < N; c++)
                if(!visited[r][c]) {
                    dfs2(r, c);
                    count++;
                }

        sb.append(count);
        System.out.println(sb);
    }

    public static void dfs1(int r, int c) {
        visited[r][c] = true;

        for(int i = 0; i < 4; i++) {
            int newR = r + dirR[i];
            int newC = c + dirC[i];
            if(isRight(newR, newC) && !visited[newR][newC] && grid[newR][newC] == grid[r][c])
                dfs1(newR, newC);
        }
    }

    private static void dfs2(int r, int c) {
        visited[r][c] = true;
        char color = grid[r][c];

        for(int i = 0; i < 4; i++) {
            int newR = r + dirR[i];
            int newC = c + dirC[i];
            if(isRight(newR, newC) && !visited[newR][newC]) {
                if(color == 'B') {
                    if(grid[newR][newC] == 'B')
                        dfs2(newR, newC);
                } else {
                    if(grid[newR][newC] != 'B')
                        dfs2(newR, newC);
                }
            }
        }
    }

    private static boolean isRight(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < N);
    }
}