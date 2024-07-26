class Solution {
    public double solution(int[] numbers) {
        double sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum / numbers.length;
    }
}