import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                list.subList(query[i] + 1, list.size()).clear();
            } else {
                list.subList(0, query[i]).clear();
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}