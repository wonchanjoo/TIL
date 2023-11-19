import java.util.*;

class Solution {
    
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    Deque<Process> queue = new ArrayDeque<>();
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
            priorityQueue.offer(priorities[i]);
        }
        
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            
            if (priorityQueue.peek() == process.priority) {
                priorityQueue.poll();
                answer++;
                
                if (process.num == location) {
                    break;
                }
            } else {
                queue.offer(process);
            }
        }
        
        return answer;
    }
    
    class Process {
        int num, priority;
        
        public Process (int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }
}