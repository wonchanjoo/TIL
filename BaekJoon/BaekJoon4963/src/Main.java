import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static boolean[][] map = new boolean[50][50];
    static boolean[][] visited = new boolean[50][50];
    static int dirR[] = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상 하 좌 우 상좌 상우 하좌 하우
    static int dirC[] = {0, 0, -1, 1, -1, 1, -1, 1}; // 상 하 좌 우 상좌 상우 하좌 하우
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) {
                break;
            }

            init();
            for(int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < w; c++) {
                    if(st.nextToken().equals("1"))
                        map[r][c] = true;
                }
            }

            count = 0;
            for(int r = 0; r < h; r++) {
                for(int c = 0; c < w; c++) {
                    if(!visited[r][c] && map[r][c]) {
                        count++;
                        dfs(r, c);
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int r, int c) {
        int nowR, nowC;
        visited[r][c] = true;

        for(int i = 0; i < 8; i++) {
            nowR = dirR[i] + r;
            nowC = dirC[i] + c;
            if (isRightRange(nowR, nowC) && !visited[nowR][nowC] && map[nowR][nowC]) {
                dfs(nowR, nowC);
            }
        }
    }

    private static boolean isRightRange(int r, int c) {
        return (r >= 0 && c >= 0 && r < h && c < w);
    }

    private static void init() {
        for(int i = 0; i < 50; i++) {
            for(int j = 0; j < 50; j++) {
                map[i][j] = false;
                visited[i][j] = false;
            }
        }
    }
}
