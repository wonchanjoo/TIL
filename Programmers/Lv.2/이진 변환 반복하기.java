class Solution {
    public int[] solution(String s) {
        int changeTime = 0;
        int deletedCount = 0;
        
        while(true) {
            // 0 제거
            int count = 0; // 1의 개수
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1')
                    count++;
            }
            deletedCount += s.length() - count; // 제거할 0의 개수
            s = "1".repeat(count);
            
            // 2진법으로 변환
            s = Long.toBinaryString(s.length());
            changeTime++;
            
            // 이진 변환 과정 끝
            if(s.equals("1"))
                break;
        }
        
        int[] result = {changeTime, deletedCount};
        return result;
    }
}