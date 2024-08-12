class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        
        for (int i = 0; i < strArr.length; i++) {
            if (i % 2 == 0) {
                answer[i] = toLower(strArr[i]);
            } else {
                answer[i] = toUpper(strArr[i]);
            }
        }
        
        return answer;
    }
    
    private String toUpper(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(Character.toUpperCase(s.charAt(i)));
        }
        return sb.toString();
    }
    
    private String toLower(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }
}