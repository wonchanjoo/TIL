class Solution {
    public int solution(int n) {
        int start = 1, end = 1;
        int sum = 1, answer = 0;
        
        while(start <= end) {
            if(sum == n) {
                answer++;
            }
            
            if(sum >= n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        
        return answer;
    }
}