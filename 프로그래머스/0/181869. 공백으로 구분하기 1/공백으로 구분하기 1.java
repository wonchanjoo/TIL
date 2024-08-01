import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(my_string);
        
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}