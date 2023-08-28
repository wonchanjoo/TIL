class Solution {
    
    final int MOD = 1_000_000_007;
    int[][] dp;
    
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n][m];
        
        // 물에 잠긴 지역 표시
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1;    
        }
        
        // dp 초기화
        int tmp = 1;
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == -1) {
                tmp = -1;
            }
            dp[i][0] = tmp;
        }
        tmp = 1;
        for (int i = 0; i < m; i++) {
            if (dp[0][i] == -1) {
                tmp = -1;
            }
            dp[0][i] = tmp;
        }
        
        // dp 채우기
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                
                long up = dp[i - 1][j] == -1 ? 0 : dp[i - 1][j];
                long left = dp[i][j - 1] == -1 ? 0 : dp[i][j - 1];
                dp[i][j] += (int) ((up + left) % MOD);
            }
        }
        
        return dp[n - 1][m - 1];
    }
}