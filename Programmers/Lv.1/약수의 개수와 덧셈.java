class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++) {
            int c = getDivisorCount(i);
            if(c % 2 == 0)
                sum += i;
            else
                sum -= i;
        }
        return sum;
    }
    
    private int getDivisorCount(int n) {
        int count = 1;
        for(int i = 1; i <= (n / 2); i++) {
            if(n % i == 0) {
                count++;
            }
        }
        return count;
    }
}