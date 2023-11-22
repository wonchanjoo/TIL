class Solution {
    public int[] solution(int n, long left, long right) {
        // 시작, 끝 행과 열 계산
        int startR = (int) (left / n);
        int startC = (int) (left % n);
        int endR = (int) (right / n);
        int endC = (int) (right % n);
        
        int length = (endR - startR + 1) * n - (startC + n - endC - 1); // 자른 배열의 길이
        int[] answer = new int[length];
        int idx = 0;
        
        while (idx < length) {
            int c = startC % n;
            
            if (c <= startR) {
                answer[idx++] = startR + 1;
            } else {
                answer[idx++] = startR + (c - startR) + 1;
            }
            
            if (++startC % n == 0) {
                startR++;
            }
        }
        
        return answer;
    }
}