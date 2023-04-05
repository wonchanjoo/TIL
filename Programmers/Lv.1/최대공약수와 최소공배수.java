class Solution {
    public int[] solution(int n, int m) {
        int[] result = new int[2];
        int min = (n < m) ? n : m;
        int max = (n > n) ? n : m;
        
        // 최대공약수
        for(int i = min; i >= 1; i--) {
            if(n % i == 0 && m % i == 0) {
                result[0] = i;
                break;
            }
        }
        
        // 최소공배수
        result[1] = n * m / result[0];
        
        return result;
    }
}