import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        PriorityQueue<Car> pq = new PriorityQueue<>();
        
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < 2; j++) {
                pq.offer(new Car(routes[i][0], routes[i][1]));
            }
        }
        
        int s = pq.peek().start;
        int e = pq.poll().end;
        while (!pq.isEmpty()) {
            Car c = pq.poll();
            
            if (c.start > e) {
                s = c.start;
                e = c.end;
                answer++;
            } else {
                s = Math.max(s, c.start);
                e = Math.min(e, c.end);
            }
        }
        
        return answer;
    }
    
    class Car implements Comparable<Car> {
        int start, end;
        
        public Car(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Car c) {
            if (this.start == c.start) {
                return this.end - c.end;
            }
            
            return this.start - c.start;
        }
    }
}