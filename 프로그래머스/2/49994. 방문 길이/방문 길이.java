import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        List<Road> roads = new ArrayList<>();
        int answer = 0;
        int x = 0, y = 0; // 시작 위치
        
        for(int i = 0; i < dirs.length(); i++) {
            switch(dirs.charAt(i)) {
                case 'U':
                    if (y + 1 <= 5) {
                        Road road = new Road(x, y, x, ++y);
                        if (!roads.contains(road)) {
                            roads.add(road);
                            answer++;
                        }
                    }
                    break;
                case 'D':
                    if (y - 1 >= -5) {
                        Road road = new Road(x, y, x, --y);
                        if (!roads.contains(road)) {
                            roads.add(road);
                            answer++;
                        }
                    }
                    break;
                case 'R':
                    if (x + 1 <= 5) {
                        Road road = new Road(x, y, ++x, y);
                        if (!roads.contains(road)) {
                            roads.add(road);
                            answer++;
                        }
                    }
                    break;
                case 'L':
                    if (x - 1 >= -5) {
                        Road road = new Road(x, y, --x, y);
                        if (!roads.contains(road)) {
                            roads.add(road);
                            answer++;
                        }
                    }
                    break;
            }
        }
        
        return answer;
    }
    
    private boolean rangeIn(int r, int c) {
        return (r >= 0) && (r < 10) && (c >= 0) && (c < 10);
    }
    
    class Road {
        int startX, startY, endX, endY;
        
        public Road(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
        
        @Override
        public boolean equals(Object o) {
            Road r = (Road) o;
            
            if (this.startX == r.startX && this.startY == r.startY && this.endX == r.endX && this.endY == r.endY) {
                return true;
            }
            
            // 방향이 반대인 경우
            if (this.startX == r.endX && this.startY == r.endY && this.endX == r.startX && this.endY == r.startY) {
                return true;
            }
            
            return false;
        }
    }
}