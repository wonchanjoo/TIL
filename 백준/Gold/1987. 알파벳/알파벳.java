import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int R, C;
    static char[][] arr;
    static boolean[][] visited;

    static Set<Character> hashSet = new HashSet<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String s = br.readLine();
            for (int c = 0; c < C; c++) {
                arr[r][c] = s.charAt(c);
            }
        }

        visited[0][0] = true;
        hashSet.add(arr[0][0]);
        dfs(0, 0, 1);

        System.out.println(answer);
    }

    private static void dfs(int r, int c, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (rangeIn(nextR, nextC) && !visited[nextR][nextC] && !hashSet.contains(arr[nextR][nextC])) {
                visited[nextR][nextC] = true;
                hashSet.add(arr[nextR][nextC]);
                dfs(nextR, nextC, count + 1);
                visited[nextR][nextC] = false;
                hashSet.remove(arr[nextR][nextC]);
            }
        }
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < R) && (c < C);
    }
}