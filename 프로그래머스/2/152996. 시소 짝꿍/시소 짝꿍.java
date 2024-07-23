import java.util.*;

class Solution {
    
    Map<Double, Integer> hashMap = new HashMap<>(); // <비율, 카운트>
    
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        // 시소 짝꿍 계산
        for (int weight : weights) {
            double[] tmp = new double[4];
            tmp[0] = weight * 1.0;
            tmp[1] = weight * 2.0 / 3.0;
            tmp[2] = weight * 1.0 / 2.0;
            tmp[3] = weight * 3.0 / 4.0;
            
            for (int i = 0; i < 4; i++) {
                if (hashMap.containsKey(tmp[i])) {
                    answer += hashMap.get(tmp[i]);
                }
            }
            
            hashMap.put((double) weight, hashMap.getOrDefault((double) weight, 0) + 1);
        }
        
        return answer;
    }
}