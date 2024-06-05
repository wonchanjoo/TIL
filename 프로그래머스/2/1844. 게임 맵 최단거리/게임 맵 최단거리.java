import java.util.*;

class Solution {
    
    int n, m;
    int[][] count, maps;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        count = new int[n][m];
        this.maps = maps;
        
        bfs();
        
        if(count[n - 1][m - 1] == 0)
            return -1;
        else
            return count[n - 1][m - 1];
    }
    
    private void bfs() {
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0));
        count[0][0] = 1;
        
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.r == n - 1 && now.c == m - 1) {
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dr[i];
                int nextC = now.c + dc[i];
                
                if (rangeIn(nextR, nextC) && maps[nextR][nextC] == 1 && count[nextR][nextC] == 0) {
                    queue.offer(new Point(nextR, nextC));
                    count[nextR][nextC] = count[now.r][now.c] + 1;
                }
            }
        }
    }
    
    private boolean rangeIn(int r, int c) {
        return (r >= 0) && (r < n) && (c >= 0) && (c < m);    
    }
}

class Point {
    int r, c;
    
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}