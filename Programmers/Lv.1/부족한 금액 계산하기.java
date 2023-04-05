class Solution {
    public long solution(int price, int money, int count) {
        long resultPrice = 0;
        
        for(int i = 1; i <= count; i++) {
            resultPrice += price * i;
        }
        
        if(resultPrice < money)
            return 0;
        
        return resultPrice - money;
    }
}