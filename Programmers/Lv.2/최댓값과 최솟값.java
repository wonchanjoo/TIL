import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.parseInt(st.nextToken());
        int max = min;
        while(st.hasMoreTokens()) {
            int token = Integer.parseInt(st.nextToken());
            if(token > max)
                max = token;
            if(token < min)
                min = token;
        }
        sb.append(min).append(' ').append(max);
        return sb.toString();
    }
}