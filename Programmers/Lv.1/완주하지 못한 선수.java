import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        LinkedList<String> parList = new LinkedList<>(Arrays.asList(participant));
        
        int i;
        for(i = 0; i < completion.length; i++) {
            if(completion[i].equals(participant[i])) {
                parList.remove();
            } else {
                break;
            }
        }
        
        return parList.get(0);
    }
}