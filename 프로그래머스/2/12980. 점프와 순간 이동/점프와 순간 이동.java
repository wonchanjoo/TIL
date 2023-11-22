import java.util.*;

public class Solution {
    public int solution(int n) {
        int battery = 0;
        
        while(n > 0) {
            if(n % 2 != 0) { // 홀수
                n--;
                battery++;
            } else { // 짝수
                n /= 2;
            }
        }

        return battery;
    }
}