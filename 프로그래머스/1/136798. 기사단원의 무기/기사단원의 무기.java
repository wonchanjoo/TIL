class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
            int divisor = getDivisorCount(i);
            if(divisor > limit)
                answer += power;
            else
                answer += divisor;
        }
        
        return answer;
    }
    
    private int getDivisorCount(int n) {
        if(n == 1)
            return 1;
        
        int count = 2; // 1과 n
        
        for(int i = 2; i <= n / 2; i++)
            if(n % i == 0)
                count++;
        
        return count;
    }
}