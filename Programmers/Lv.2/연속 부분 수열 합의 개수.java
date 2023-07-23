import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> h = new HashSet<>();
        int size = 1;
        
        while(true) {
            int s = 0;
            int e = size;
            int sum = 0;
            
            // 초기 sum 값
            for(int i = s; i < e; i++)
                sum += elements[i];
            h.add(sum);
            
            // 최대 크기인 경우 반복문을 빠져나온다.
            if(size == elements.length)
                break;
            
            // 원형 배열을 순환하기 위해 한 단계 순환 먼저 해준다.
            sum -= elements[s];
            sum += elements[e];
            h.add(sum);
            s = (s + 1) % elements.length;
            e = (e + 1) % elements.length;
            
            while(s != 0) {
                sum -= elements[s];
                sum += elements[e];
                h.add(sum);
                
                s = (s + 1) % elements.length;
                e = (e + 1) % elements.length;
            }
            
            size++;
        }
        
        return h.size();
    }
}