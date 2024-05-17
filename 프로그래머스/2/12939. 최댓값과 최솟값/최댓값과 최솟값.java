import java.util.*;

class Solution {
    
    List<Integer> list = new ArrayList<>();
    
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);
        return list.get(0) + " " + list.get(list.size() - 1);
    }
}