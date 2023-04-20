class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(first && c != ' ') { // 첫번째
                if(Character.isLetter(c)) { // 문자인 경우
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
                first = false;
                continue;
            } else if(c == ' ') {
                first = true;
            } else if(Character.isLetter(c)) {
                c = Character.toLowerCase(c);
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}