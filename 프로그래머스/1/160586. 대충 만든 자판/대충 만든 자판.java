import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> keyHashMap = new HashMap<>();
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                Character c = keymap[i].charAt(j);
                if(keyHashMap.containsKey(c)) {
                    if(keyHashMap.get(c) > j) {
                        keyHashMap.put(c, j + 1);
                    }
                } else {
                    keyHashMap.put(c, j + 1);
                }
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            int sum = 0;
            
            for(int j = 0; j < targets[i].length(); j++) {
                Character c = targets[i].charAt(j);
                if(keyHashMap.containsKey(c)) {
                    sum += keyHashMap.get(c);
                } else {
                    sum = -1;
                    break;
                }
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}