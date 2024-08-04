import java.util.*;

class Solution {
    
    int n;
    int[] arr1, arr2;
    char[][] map;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        this.n = n;
        this.arr1 = arr1;
        this.arr2 = arr2;
        map = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            boolean[] binary1 = getBinary(arr1[i]);
            boolean[] binary2 = getBinary(arr2[i]);
            for (int j = 0; j < n; j++) {
                if (binary1[j] || binary2[j]) {
                    map[i][j] = '#';
                } else {
                    map[i][j] = ' ';
                }
            }
        }
        
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    private boolean[] getBinary(int num) {
        boolean[] binary = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            binary[n - 1 - i] = (num & (1 << i)) != 0;
        }
        
        return binary;
    }
}