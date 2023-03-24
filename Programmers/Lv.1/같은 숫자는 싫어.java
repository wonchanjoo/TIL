import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        int topValue = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == topValue)
                continue;
            queue.offer(arr[i]);
            topValue = arr[i];
        }
        
        int[] result = new int[queue.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        
        return result;
    }
}