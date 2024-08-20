import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        
        for (int i : works) {
            pq.offer(i);
        }
        
        while (!pq.isEmpty() && n-- > 0) {
            int i = pq.poll();
            if (i > 1) {
                pq.offer(i - 1);
            }
        }
        
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}