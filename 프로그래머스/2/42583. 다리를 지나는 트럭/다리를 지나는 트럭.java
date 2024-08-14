import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int time = 0;
        int sum = 0;
        for (int truck : truck_weights) {
            while (true) {
                time++;
                
                if (sum - bridge.peek() + truck > weight) {
                    sum -= bridge.poll();
                    bridge.offer(0);
                } else {
                    sum -= bridge.poll();
                    bridge.offer(truck);
                    sum += truck;
                    break;
                }
            }
        }
        
        while (!bridge.isEmpty()) {
            time++;
            bridge.poll();
        }
        
        return time;
    }
}