class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        
        // 0행 초기화
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        // 나머지 dp 배열 채워주기
        for (int r = 1; r < dp.length; r++) {
            for (int c = 0; c < 4; c++) {
                
                int max = 0;
                for (int i = 0; i < 4; i++) {
                    if (i == c)     continue;
                    max = Math.max(dp[r - 1][i], max);
                }
                
                dp[r][c] = max + land[r][c];
            }
        }
        
        // 최고점 찾기
        int answer = dp[dp.length - 1][0];
        for (int i = 1; i < 4; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        
        return answer;
    }
}