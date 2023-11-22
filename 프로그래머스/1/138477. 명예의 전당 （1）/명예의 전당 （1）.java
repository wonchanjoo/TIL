import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] result = new int[score.length];
        int i = 0; // result의 index
        ArrayList<Integer> rank = new ArrayList<>();
        
        for(int j = 0; j < score.length; j++) {
            if(rank.size() < k) {
                rank.add(score[j]);
            } else if(rank.get(0) < score[j]){ // 가장 작은 값보다 크면
                rank.remove(0);
                rank.add(score[j]);
            }
            Collections.sort(rank);
            result[i++] = rank.get(0);
        }
        
        return result;
    }
}