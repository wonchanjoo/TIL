import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 뒷 번호와 비교
            int minLen = Math.min(phone_book[i].length(), phone_book[i + 1].length());
            String now = phone_book[i].substring(0, minLen);
            String next = phone_book[i + 1].substring(0, minLen);
            if (now.equals(next)) {
                return false;
            }
        }
        
        return true;
    }
}