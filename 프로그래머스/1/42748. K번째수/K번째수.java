import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int index = 0;
        
        for(int p = 0; p < commands.length; p++) {
            int i = commands[p][0];
            int j = commands[p][1];
            int k = commands[p][2];
            
            int[] arr = new int[j - i + 1];
            int arrIndex = 0;
            for(int q = (i - 1); q < j; q++) {
                arr[arrIndex++] = array[q];
            }
            
            Arrays.sort(arr);
            result[index++] = arr[k - 1];
        }
        return result;
    }
}