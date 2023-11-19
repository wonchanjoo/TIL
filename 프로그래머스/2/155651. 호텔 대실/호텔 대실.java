import java.util.*;

class Solution {
    
    PriorityQueue<Integer> rooms = new PriorityQueue<>();
    PriorityQueue<Time> pq = new PriorityQueue<>();
    
    public int solution(String[][] book_time) {
        for (int i = 0; i < book_time.length; i++) {
            int start = getMinute(book_time[i][0]);
            int end = getMinute(book_time[i][1]);
            pq.offer(new Time(start, end));
        }
        
        while (!pq.isEmpty()) {
            Time now = pq.poll();
            
            if (!rooms.isEmpty() && rooms.peek() <= now.start) {
                rooms.poll();
            }
            
            rooms.offer(now.end + 10);
        }
        
        return rooms.size();
    }
    
    private int getMinute(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }
    
    class Time implements Comparable<Time> {
        int start, end;
        
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Time time) {
            if (this.start == time.start) {
                return time.end - this.end;
            }
            return this.start - time.start;
        }
    }
}