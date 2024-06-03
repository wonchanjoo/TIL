import java.util.*;

class Solution {
    
    List<Integer> list = new ArrayList<>();
    int min, max;
    
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        min = max = Integer.parseInt(st.nextToken());
        
        while (st.hasMoreTokens()) {
            int i = Integer.parseInt(st.nextToken());
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        return min + " " + max;
    }
}