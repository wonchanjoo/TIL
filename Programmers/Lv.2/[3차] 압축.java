import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        ArrayList<String> dict = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        int i = 0, j;
        int add = 27;
        
        for(j = 0; j < 26; j++)
            dict.add(Character.toString('A' + j));
        
        while(i < msg.length()) {
            // 가장 긴 문자열 w를 찾는다.
            String w = "";
            for(j = i + 1; j <= msg.length(); j++) {
                w = msg.substring(i, j);
                if(!dict.contains(w))  // 사전에 없으면 break
                    break;
            }
            
            // 색인 번호를 출력한다.
            index.add(dict.indexOf(msg.substring(i, j - 1)) + 1);
            
            // 사전에 추가한다.
            dict.add(w);
            
            i = j - 1;
        }
        
        int[] answer = new int[index.size()];
        for(j = 0; j < answer.length; j++)
            answer[j] = index.get(j);
        return answer;
    }
}