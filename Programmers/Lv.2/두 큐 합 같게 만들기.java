import java.util.*;

class Solution {
    
    long sum1, sum2;
    Deque<Integer> q1, q2;
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        sum1 = sum2 = 0;
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        // sum이 홀수인 경우 합을 같게 만들 수 없다.
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        while (sum1 != sum2) {
            if (answer > (queue1.length + queue2.length + 1)) {
                answer = -1;
                break;
            }
            
            if (sum1 < sum2) {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.offer(q2.poll());
            } else {
                sum2 += q1.peek();
                sum1 -= q1.peek();
                q2.offer(q1.poll());
            }
            answer++;
        }
        
        return answer;
    }
}