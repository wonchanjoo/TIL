import java.util.*;

class Solution {
    
    String target;
    String[] words;
    boolean[] visited;
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        this.visited = new boolean[words.length];
        
        dfs(begin, 0);
        
        if (answer == Integer.MAX_VALUE) {
            return 0;
        } else {
            return answer;
        }
    }
    
    private void dfs(String word, int count) {
        if (count >= answer) {
            return;
        }
        
        if (word.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && convert(word, words[i])) {
                visited[i] = true;
                dfs(words[i], count + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean convert(String from, String to) {
        int count = 0;
        
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) == to.charAt(i)) {
                count++;
            }
        }
        
        return count == (from.length() - 1);
    }
}
