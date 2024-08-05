class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (true) {
            int empty = n / a; // 가져다 줄 수 있는 빈 병의 개수
            int coke = empty * b; // 마트가 주는 콜라의 개수
            int tmp = n % a; // 남은 빈 병의 개수
            
            if (empty == 0) {
                break;
            }
            
            answer += coke;
            n = coke + tmp;
        }
        
        return answer;
    }
}