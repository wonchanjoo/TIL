import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++)
            hash.put(tangerine[i], hash.getOrDefault(tangerine[i], 0) + 1);
        
        int[] count = new int[hash.size()];
        int idx = 0;
        for (int j : hash.values())
            count[idx++] = j;
        
        Arrays.sort(count);
        
        int answer = 0;
        idx = count.length - 1;
        while(k > 0) {
            k -= count[idx--];
            answer++;
        }
        
        return answer;
    }
}