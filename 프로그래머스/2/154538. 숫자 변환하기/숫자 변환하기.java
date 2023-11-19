import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int x, int y, int n) {
        int[] count = new int[y + 1];
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        count[x] = 1;
        
        while(!q.isEmpty()) {
            int i = q.poll();
            if(i == y)
                break;
            
            if(i * 3 <= y && count[i * 3] == 0) {
                q.offer(i * 3);
                count[i * 3] = count[i] + 1;
            }
            if(i * 2 <= y && count[i * 2] == 0) {
                q.offer(i * 2);
                count[i * 2] = count[i] + 1;
            }
            if(i + n <= y && count[i + n] == 0) {
                q.offer(i + n);
                count[i + n] = count[i] + 1;
            }
        }
        
        if(count[y] == 0)
            return -1;
        else
            return count[y] - 1;
    }
}