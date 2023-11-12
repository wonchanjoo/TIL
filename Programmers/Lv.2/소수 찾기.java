import java.util.*;

class Solution {
    
    Set<Integer> hashSet = new HashSet<>();
    String numbers;
    boolean[] visited;
    int answer = 0;
    
    public int solution(String numbers) {
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        
        for (int i = 0; i < numbers.length(); i++) {
            visited[i] = true;
            dfs(numbers.substring(i, i + 1));
            visited[i] = false;
        }
        
        return answer;
    }
    
    private void dfs(String str) {
        int n = Integer.parseInt(str);
        if (!hashSet.contains(n) && isPrimeNumber(n)) {
            answer++;
            hashSet.add(n);
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(str + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i <= (n / 2); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}