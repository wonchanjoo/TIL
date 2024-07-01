import java.util.*;

class Solution {
    
    final int[] dr = {-1, 1, 0, 0};
    final int[] dc = {0, 0, -1, 1};
    
    int N, M;
    int[][] map;
    boolean[][] visited;
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
    
        // BFS를 사용해서 무인도를 탐색한다.
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }
        
        if (answer.size() == 0) {
            return new int[]{-1};
        } else {
            Collections.sort(answer);
            return arrayListToArr(answer);
        }
    }
    
    private int bfs(int r, int c) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(r, c));
        visited[r][c] = true;
        
        int sum = map[r][c];
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if (rangeIn(nr, nc) && map[nr][nc] > 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    sum += map[nr][nc];
                    queue.offer(new Point(nr, nc));
                }
            }
        }
        
        return sum;
    }
    
    private boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < M);
    }
    
    private int[] arrayListToArr(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    
    class Point {
        int r, c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}