class Solution {
    boolean solution(String s) {
        int pCount = 0, yCount = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'p' || c == 'P') {
                pCount++;
            } else if(c == 'y' || c == 'Y') {
                yCount++;
            }
        }
        
        if(pCount == yCount) {
            return true;
        } else if(pCount == 0 && yCount == 0) {
            return true;
        } else {
            return false;
        }
    }
}