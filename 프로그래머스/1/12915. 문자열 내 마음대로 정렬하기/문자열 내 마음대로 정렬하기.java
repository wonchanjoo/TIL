import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        PriorityQueue<String> q = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                char c1 = s1.charAt(n);
                char c2 = s2.charAt(n);
                if(c1 == c2) {
                    return s1.compareTo(s2);
                } else {
                    return c1 - c2;
                }
            }
        });
        
        for(int i = 0; i < strings.length; i++) {
            q.offer(strings[i]);
        }
        for(int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
        }
        
        return answer;
    }
}