import java.util.*;

class Solution {
    
    int n, m;
    int[][] count;
    int[] dirR = {-1, 1, 0, 0};
    int[] dirC = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        count = new int[n][m];
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0)); // 문제의 (1, 1)을 (0, 0)으로
        count[0][0] = 1;
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nextR = p.r + dirR[i];
                int nextC = p.c + dirC[i];
                
                if(rangeIn(nextR, nextC) && maps[nextR][nextC] == 1 && count[nextR][nextC] == 0) {
                    q.offer(new Point(nextR, nextC));
                    count[nextR][nextC] = count[p.r][p.c] + 1;
                }
            }
        }
        
        if(count[n - 1][m - 1] == 0)
            return -1;
        else
            return count[n - 1][m - 1];
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