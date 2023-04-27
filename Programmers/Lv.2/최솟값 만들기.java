import java.util.PriorityQueue;
import java.util.Collections;

class Solution
{
    public int solution(int []A, int []B)
    {
        PriorityQueue<Integer> lowest = new PriorityQueue<>();
        PriorityQueue<Integer> highest = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < A.length; i++) {
            lowest.add(A[i]);
            highest.add(B[i]);
        }
        
        int answer = 0;
        for(int i = 0; i < A.length; i++) {
            answer += (lowest.poll() * highest.poll());
        }
        
        return answer;
    }
}