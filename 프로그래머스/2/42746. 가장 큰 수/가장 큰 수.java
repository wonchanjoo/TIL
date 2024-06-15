import java.util.*;

class Solution {
    
    PriorityQueue<String> pq;
    
    public String solution(int[] numbers) {
        pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String case1 = s1 + s2;
                String case2 = s2 + s1;
                return case2.compareTo(case1);
            }
        });
        
        for (int i = 0; i < numbers.length; i++) {
            pq.offer(Integer.toString(numbers[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        
        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}