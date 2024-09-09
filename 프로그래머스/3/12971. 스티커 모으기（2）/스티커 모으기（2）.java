class Solution {
    public int solution(int sticker[]) {
        int[][] dp = new int[2][sticker.length];
        
        if (sticker.length == 1) {
            return sticker[0];
        }
        
        // 1. 첫번째 스티커를 뜯는 경우
        dp[0][0] = dp[0][1] = sticker[0];
        
        for (int i = 2; i < sticker.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + sticker[i]);
        }
        
        // 2. 첫번째 스티커를 뜯지 않는 경우
        dp[1][1] = sticker[1];
        
        for (int i = 2; i < sticker.length; i++) {
            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + sticker[i]);
        }
        
        return Math.max(dp[0][sticker.length - 2], dp[1][sticker.length - 1]);
    }
}