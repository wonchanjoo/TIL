import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                break;
            }
            
            int max = pq.poll();
            if (max - 1 > 0) {
                pq.offer(max - 1);
            }
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            int job = pq.poll();
            answer += Math.pow(job, 2);
        }
        
        return answer;
    }
}