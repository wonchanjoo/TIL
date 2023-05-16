import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        ArrayList<Integer> selected = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!selected.contains(nums[i])) {
                selected.add(nums[i]);
            }
            if(selected.size() == nums.length / 2) {
                break;
            }
        }
        
        return selected.size();
    }
}