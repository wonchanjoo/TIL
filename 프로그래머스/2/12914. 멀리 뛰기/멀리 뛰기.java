class Solution {
    public long solution(int n) {
        long[] D = new long[2001];
        
        D[1] = 1;
        D[2] = 2;
        
        for(int i = 3; i <= n; i++)
            D[i] = (D[i - 1] + D[i - 2]) % 1234567;
        
        return D[n];
    }
}