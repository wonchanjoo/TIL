class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long size = p.length();
        long pNum = Long.parseLong(p);
        
        for(long i = 0; i <= t.length() - size; i++) {
            String s = t.substring((int)i, (int)(i + size));
            if(Long.parseLong(s) <= pNum) {
                answer++;
            }
        }

        return answer;
    }
}