class Solution {
    
    final int[] arr = {5, 3, 1};
    
    public int solution(int hp) {
        int answer = 0;
        
        for (int i : arr) {
            answer += (hp / i);
            hp %= i;
        }
        
        return answer;
    }
}