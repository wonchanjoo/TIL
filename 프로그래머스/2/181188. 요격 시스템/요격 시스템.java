import java.util.*;

class Solution {
    
    Point[] points;
        
    public int solution(int[][] targets) {
        // targets 배열 -> Point 배열 변환
        points = new Point[targets.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(targets[i][0], targets[i][1]);
        }
        
        Arrays.sort(points);
        
        int answer = 1;
        int start = points[0].s;
        int end = points[0].e;
        for (int i = 1; i < points.length; i++) {
            // 구간이 겹치는 경우
            if (end > points[i].s) {
                start = Math.max(start, points[i].s);
                end = Math.min(end, points[i].e);
            } 
            // 구간이 겹치지 않는 경우
            else {
                answer++;
                end = points[i].e;
            }
        }
        
        return answer;
    }
    
    static class Point implements Comparable<Point> {
        int s, e;
        
        public Point(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Point p) {
            if (this.e == p.e) {
                return this.s - p.s;
            }
            return this.e - p.e;
        }
    }
}