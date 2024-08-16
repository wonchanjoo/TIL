class Solution {
    public int solution(int n) {
        int answer = 2;
        
        int i = 1;
        while (Math.pow(i, 2) <= n) {
            if (Math.pow(i, 2) == n) {
                answer = 1;
                break;
            }
            i++;
        }
        
        return answer;
    }
}