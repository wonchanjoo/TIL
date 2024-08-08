import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;
        int idx = 0;
        
        while (idx < number.length() && sb.length() < len) {
            int tmp = k + sb.length() + 1;
            int max = 0;
            
            for (int i = idx; i < tmp; i++) {
                if (max < (int) (number.charAt(i) - '0')) {
                    max = (int) (number.charAt(i) - '0');
                    idx = i + 1;
                }
            }
            
            sb.append(max);
        }
        
        return sb.toString();
    }
}