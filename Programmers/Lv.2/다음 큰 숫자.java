class Solution {
    public int solution(int n) {
        int i = n + 1;
        int nCount = get1Count(Integer.toBinaryString(n));
        while(true) {
            int iCount = get1Count(Integer.toBinaryString(i));
            if(nCount == iCount)
                return i;
            i++;
        }
        
    }
    
    private int get1Count(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1')
                count++;
        }
        return count;
    }
}