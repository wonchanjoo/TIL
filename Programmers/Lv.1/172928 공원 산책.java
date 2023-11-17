class Solution {
    
    int H, W, nowR, nowC;
    char[][] map;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        H = park.length;
        W = park[0].length();
        map = new char[H][W];
        
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                map[r][c] = park[r].charAt(c);
                
                if (map[r][c] == 'S') {
                    nowR = r;
                    nowC = c;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            String direction = routes[i].split(" ")[0];
            int count = Integer.parseInt(routes[i].split(" ")[1]);
            int idx = -1;
            
            switch(direction) {
                case "N":
                    idx = 0;
                    break;
                case "S":
                    idx = 1;
                    break;
                case "W":
                    idx = 2;
                    break;
                case "E":
                    idx = 3;
                    break;
            }
            
            if (move(nowR, nowC, idx, count)) {
                nowR += dr[idx] * count;
                nowC += dc[idx] * count;
            }
        }
        
        return new int[]{nowR, nowC};
    }
    
    private boolean move(int r, int c, int direction, int count) {
        for (int i = 0; i < count; i++) {
            int nextR = r + dr[direction];
            int nextC = c + dc[direction];
            
            if (!rangeIn(nextR, nextC) || map[nextR][nextC] == 'X') {
                return false;
            }
            
            r = nextR;
            c = nextC;
        }
        
        return true;
    }
    
    private boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < H) && (c < W);
    }
}