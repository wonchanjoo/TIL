import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        
        int i;
        int j = 1;
        while(true) {
            i = 0;
            for(; i < arr.length - 1; i++) {
                if((max * j) % arr[i] != 0) {
                    break;
                }
            }
            if(i == arr.length - 1) {
                break;
            }
            j++;
        }
        return max * j;
    }
}