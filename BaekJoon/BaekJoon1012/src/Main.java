import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] ground;
    private static boolean[][] visited;

    public static void fillGround(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        // 시작 노드 처리
        queue.offer(new Point(startX, startY));
        visited[startX][startY] = true;
        while(!queue.isEmpty()) {
            Point node = queue.poll();
            int x = node.x;
            int y = node.y;
            // 상
            if(x > 0) {
                if(ground[x - 1][y] == 1 && !visited[x - 1][y]) {
                    queue.offer(new Point(x - 1, y));
                    visited[x - 1][y] = true;
                }
            }
            // 하
            if(x < (ground.length - 1)) {
                if(ground[x + 1][y] == 1 && !visited[x + 1][y]) {
                    queue.offer(new Point(x + 1, y));
                    visited[x + 1][y] = true;
                }
            }
            // 좌
            if(y > 0) {
                if(ground[x][y - 1] == 1 && !visited[x][y - 1]) {
                    queue.offer(new Point(x, y - 1));
                    visited[x][y - 1] = true;
                }
            }
            // 우
            if(y < (ground[0].length - 1)) {
                if(ground[x][y + 1] == 1 && !visited[x][y + 1]) {
                    queue.offer(new Point(x, y + 1));
                    visited[x][y + 1] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- != 0) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로 길이
            int N = Integer.parseInt(st.nextToken()); // 세로 길이
            ground = new int[N][M];
            visited = new boolean[N][M];
            int K = Integer.parseInt(st.nextToken()); // 배추가 심어져있는 위치의 개수
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                ground[Y][X] = 1;
            }

            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    if(ground[r][c] == 1 && !visited[r][c]) {
                        fillGround(r, c);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb.toString());
    }
}
