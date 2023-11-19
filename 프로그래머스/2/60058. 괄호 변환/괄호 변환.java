class Solution {
    public String solution(String p) {
        return correct(p);
    }
    
    private String correct(String w) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환한다.
        if (w.length() == 0) {
            return "";
        }
        
        // 2. 문자열 w를 두 균형잡힌 괄호 문자열 u, v로 분리한다.
        int leftCnt, rightCnt, i;
        leftCnt = rightCnt = i = 0;
        boolean isCorrect = true;
        for (i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                leftCnt++;
            } else {
                rightCnt++;
            }
            
            
            if (leftCnt < rightCnt) {
                isCorrect = false;
            }
            if (leftCnt == rightCnt) {
                break;
            }
        }
        
        String u = w.substring(0, i + 1);
        String v = w.substring(i + 1);
        
        // 3. u가 올바른 괄호 문자열인 경우
        if (isCorrect) {
            return u + correct(v);
        }
        // 4. u가 올바른 괄호 문자열이 아닌 경우
        else {
            String tmp = "(" + correct(v) + ")";
            StringBuilder sb = new StringBuilder();
            for (i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }
            tmp += sb.toString();
            return tmp;
        }
    }
}