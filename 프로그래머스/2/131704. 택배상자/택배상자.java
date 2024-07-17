import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 1; i <= order.length; i++) {
            queue.offer(i);
        }
        
        for (int i = 0; i < order.length; i++) {
            // 컨테이너 벨트에서 꺼내는 경우
            if (!queue.isEmpty() && queue.peek() == order[i]) {
                queue.poll();
                answer++;
                continue;
            }
            
            // 보조 컨테이너 벨트에서 꺼내는 경우
            if (!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                answer++;
                continue;
            }
            
            // 보조 컨테이너 벨트로 옮기수 있는 만큼 옮긴다.
            while (!queue.isEmpty() && queue.peek() < order[i]) {
                stack.push(queue.poll());
            }
            
            if (!queue.isEmpty() && queue.peek() == order[i]) {
                queue.poll();
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}