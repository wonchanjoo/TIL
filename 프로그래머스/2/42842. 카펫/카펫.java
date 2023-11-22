import java.util.ArrayList;

class Solution {
    public int[] solution(int brown, int yellow) {
        ArrayList<Integer> divisors = getDivisors(yellow); // 이미 정렬되어 있다.
        for(int i = 0; i < divisors.size(); i++) {
            for(int j = i; j < divisors.size(); j++) {
                int h = divisors.get(i);
                int w = divisors.get(j);
                if(2 * w + 2 * h + 4 == brown && w * h == yellow) {
                    return (new int[]{(w + 2), (h + 2)});
                }
            }
        }
        
        return null;
    }
    
    private ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }
}