import java.util.*;
import java.util.Map.Entry;

class Solution {
    
    int answer = 0;
    Map<String, Integer> w = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        // want, number 배열 -> HashMap 자료구조로 저장
        for (int i = 0; i < want.length; i++) {
            w.put(want[i], number[i]);
        }
        
        // 처음 1일 ~ 10일
        for (int i = 0; i < 10; i++) {
            // 원하는 제품인 경우
            if (w.containsKey(discount[i])) {
                w.put(discount[i], w.get(discount[i]) - 1);
            }
        }
        
        if (check()) {
            answer++;
        }
        
        int start = 0;
        int end = 10;
        while (end < discount.length) {
            // 날짜 이동
            if (w.containsKey(discount[start])) {
                w.put(discount[start], w.get(discount[start]) + 1);
            }
            if (w.containsKey(discount[end])) {
                w.put(discount[end], w.get(discount[end]) - 1);
            }
            
            
            if (check()) {
                answer++;
            }
            
            start++;
            end++;
        }
        
        return answer;
    }

    private boolean check() {
        for (String key : w.keySet()) {
            if (w.get(key) > 0) {
                return false;
            }
        }
        
        return true;
    }
}