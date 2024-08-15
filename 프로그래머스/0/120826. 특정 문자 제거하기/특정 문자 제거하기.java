import java.util.*;

class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            if (!my_string.substring(i, i + 1).equals(letter)) {
                sb.append(my_string.substring(i, i + 1));
            }
        }
        
        return sb.toString();
    }
}