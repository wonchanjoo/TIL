import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer[]> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            queue.offer(new Integer[]{progresses[i], speeds[i]});
        }

        while(!queue.isEmpty()) {
            int count = 1;
            Integer[] job = queue.poll();
            
            for(int i = 1; i <= 100; i++) { 
                if(job[0] + job[1] * i >= 100) { // i: 배포되는 날짜
                    
                    while(!queue.isEmpty()) { // 뒤에 있는 작업 중 이미 끝난걸 찾는다.
                        if(queue.peek()[0] + queue.peek()[1] * i >= 100) {
                            queue.poll();
                            count++;
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}