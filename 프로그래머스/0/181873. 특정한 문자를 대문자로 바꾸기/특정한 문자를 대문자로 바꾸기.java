import java.util.*;

class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) == alp.charAt(0)) {
                sb.append((char) (alp.charAt(0) - 32));
            } else {
                sb.append(my_string.charAt(i));
            }
        }
        
        return sb.toString();
    }
}