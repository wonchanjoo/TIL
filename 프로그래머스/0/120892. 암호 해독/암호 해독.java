import java.util.*;

class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        
        int i = 1;
        while ((code * i - 1) < cipher.length()) {
            sb.append(cipher.charAt(code * i - 1));
            i++;
        }
        
        return sb.toString();
    }
}