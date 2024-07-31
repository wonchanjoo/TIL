import java.util.*;

class Solution {
    
    final int[] dr = {-1, 1, 0, 0};
    final int[] dc = {0, 0, -1, 1};
    
    int n, m;
    int[][] land;
    boolean[][] visited;
    
    int id = 1;
    Map<Integer, Integer> hashMap = new HashMap<>();
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        this.land = land;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (!visited[r][c] && land[r][c] > 0) {
                    visited[r][c] = true;
                    bfs(r, c);
                    id++;
                }
            }
        }
        
        int[] result = new int[m];
        for (int c = 0; c < m; c++) {
            int sum = 0;
            Set<Integer> hashSet = new HashSet<>();
            
            for (int r = 0; r < n; r++) {
                if (land[r][c] > 0 && !hashSet.contains(land[r][c])) {
                    sum += hashMap.get(land[r][c]);
                    hashSet.add(land[r][c]);
                }
            }
            result[c] = sum;
        }
        
        Arrays.sort(result);
        return result[result.length - 1];
    }
    
    private void bfs(int r, int c) {
        List<Point> list = new ArrayList<>();
        Deque<Point> queue = new ArrayDeque<>();
        list.add(new Point(r, c));
        queue.offer(new Point(r, c));
        
        int size = 1;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if (rangeIn(nr, nc) && !visited[nr][nc] && land[nr][nc] > 0) {
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc));
                    list.add(new Point(nr, nc));
                    size++;
                }
            }
        }
        
        hashMap.put(id, size);
        for (int i = 0; i < list.size(); i++) {
            Point point = list.get(i);
            land[point.r][point.c] = id;
        }
    }
    
    private boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < n) && (c < m);
    }
    
    class Point {
        int r, c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}