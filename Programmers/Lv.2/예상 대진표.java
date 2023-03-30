class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 0;
        while(a != b) { 
            round++;
            int j = 0; // 다음 round에서 부여 받을 번호
            for(int i = 1; i <= n; i += 2) {
                j++;
                if(i == a || (i + 1) == a) {
                    a = j;
                }
                if(i == b || (i + 1) == b) {
                    b = j;
                }
                if(a == b) {
                    break; // for문 빠져나옴
                }
            }
            n /= 2;
        }
        return round;
    }
}