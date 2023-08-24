class Solution {
    
    int[][] dp;
    
    public int solution(int[][] triangle) {
        int N = triangle.length;
        dp = new int[N + 1][N + 1];
        
        for (int r = 1; r <= triangle.length; r++) {
            for (int c = 1; c <= triangle[r - 1].length; c++) {
                dp[r][c] = Math.max(dp[r - 1][c - 1], dp[r - 1][c]) + triangle[r - 1][c - 1];
            }
        }
        
        // 최댓값 찾기
        int max = dp[N][1];
        for (int i = 2; i <= N; i++) {
            max = Math.max(max, dp[N][i]);
        }
        
        return max;
    }
    
}