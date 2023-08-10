import java.util.*;

class Solution {
    public int[] solution(String s) {
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        Set<Integer> set = new HashSet<>();
        List<Integer> answerList = new ArrayList<>();
        
        String[] str = s.substring(2, s.length() - 2).split("\\},\\{");
        for (int i = 0; i < str.length; i++) {
            pq.offer(str[i]);
        }
        
        while (!pq.isEmpty()) {
            String[] tmp = pq.poll().split(",");
            
            for (int i = 0; i < tmp.length; i++) {
                int n = Integer.parseInt(tmp[i]);
                
                if (set.add(n)) {
                    answerList.add(n);
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}