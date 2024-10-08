class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int mul = 1;
        
        for (int i : num_list) {
            sum += i;
            mul *= i;
        }
        
        if (mul < Math.pow(sum, 2)) {
            return 1;
        } else {
            return 0;
        }
    }
}