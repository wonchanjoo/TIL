import java.util.*;

class Solution {
    
    Map<Integer, Integer> hashMap1 = new HashMap<>();
    Map<Integer, Integer> hashMap2 = new HashMap<>();
    
    public int solution(int[] topping) {
        // 한명이 케이크를 다 먹는 경우
        for (int i = 0; i < topping.length; i++) {
            hashMap1.put(topping[i], hashMap1.getOrDefault(topping[i], 0) + 1);
        }
        
        int answer = 0;
        int idx = 0;
        while (idx < topping.length) {
            int tmp = hashMap1.get(topping[idx]);
            if (tmp == 1) {
                hashMap1.remove(topping[idx]);
            } else {
                hashMap1.put(topping[idx], tmp - 1);
            }
            hashMap2.put(topping[idx], hashMap2.getOrDefault(topping[idx], 0) + 1);
            
            if (hashMap1.size() == hashMap2.size()) {
                answer++;
            }
            
            idx++;
        }
        
        return answer;
    }
}