import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> cache = new ArrayList<>();
        int answer = 0;
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            
            // hit
            if(cache.contains(city)) {
                answer += 1;
                
                cache.remove(city);
                cache.add(city);
            } 
            // miss
            else {
                answer += 5;
                if(cacheSize > 0) {
                    if(cache.size() < cacheSize) { // 아직 캐시가 꽉 차지 않은 경우
                        cache.add(city);
                    } else {
                        cache.remove(0); // 맨 앞 삭제
                        cache.add(city);
                    }
                }
            }
        }
        
        return answer;
    }
}