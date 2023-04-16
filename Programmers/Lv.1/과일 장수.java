import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {  
        Arrays.sort(score);
        
        int profit = 0;
        for(int i = (score.length % m); i < score.length; i += m) {
            profit = profit + (score[i] * m);
        }
        return profit;
    }
}