class Solution {
    public int solution(int a, int b) {
        int tmp = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        return Math.max(tmp, 2 * a * b);
    }
}