import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);
        
        int answer = 0;
        while(q.size() > 1) {
            if(q.peek() >= K)
                break;
            
            int mmin = q.poll();
            int min = q.poll();
            int mix = mmin + min * 2;
            q.offer(mix);
            answer++;
        }
        
        if(!q.isEmpty() && q.peek() < K)
            return -1;
        else
            return answer;
    }
}