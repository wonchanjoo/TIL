import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                sb.append(' ');
                j = 0;
                continue;
            }
            
            if(j % 2 == 0) { // 짝수번째 - 대문자
                sb.append(Character.toUpperCase(c));
            } else { // 홀수번째 - 소문자
                sb.append(Character.toLowerCase(c));
            }
            j++;
        }
        
        return sb.toString();
    }
}