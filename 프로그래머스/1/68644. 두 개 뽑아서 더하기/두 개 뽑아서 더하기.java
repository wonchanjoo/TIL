import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if(!list.contains(sum)) {
                    list.add(sum);
                }
            }
        }
        
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        
        return arr;
    }
}