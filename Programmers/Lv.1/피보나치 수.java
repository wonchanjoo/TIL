class Solution {
    public int solution(int n) {
        long pp = 1;
        long p = 1;
        
        for(int i = 3; i <= n; i++) {
            long current = pp + p;  
            pp = p;
            p = current % 1234567;
        }
        
        return (int)p;
    }
}