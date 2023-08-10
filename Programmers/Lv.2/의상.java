import java.util.*;

class Solution {
    
    HashMap<String, Integer> hashMap = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }
        
        Iterator<String> keys = hashMap.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            int value = hashMap.get(key);
            
            answer *= (value + 1);
        }
        
        return answer - 1;
    }
}