import java.util.*;
import java.util.Map.Entry;

class Solution {
    
    HashMap<String, Integer> w = new HashMap<>();
    HashMap<String, Integer> d = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        int count;
        
        // HashMap<제품, 수량> 
        for(int i = 0; i < want.length; i++)
            w.put(want[i], number[i]);
        
        // 첫번째 기간
        for(int i = 0; i < 10; i++) {
            int temp = d.getOrDefault(discount[i], 0);
            d.put(discount[i], temp + 1);
        }
        
        if(discount(d))
            count = 1;
        else
            count = 0;
        
        int s = 0, e = 10;
        while(e < discount.length) {
            // s 삭제
            int temp = d.get(discount[s]);
            d.put(discount[s++], temp - 1);
            
            // e 추가
            temp = d.getOrDefault(discount[e], 0);
            d.put(discount[e++], temp + 1);
            
            if(discount(d))
                count++;
        }
        
        return count;
    }
    
    private boolean discount(HashMap<String, Integer> d) {
        for(Entry<String, Integer> entry: w.entrySet()) {
            if (d.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}