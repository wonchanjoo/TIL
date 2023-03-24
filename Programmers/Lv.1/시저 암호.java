class Solution {
    public String solution(String s, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(('a' <= c && c <= 'z')) {
                    char encodedChar = (c + 1) % 'z';
                    s = s.substring(0, j) + Character.toString(encodedChar) + s.substring(j + 1, s.length());
                } else if(('A' <= c && c <= 'Z')) {
                    char encodedChar = (c + 1) % 'Z';
                    s = s.substring(0, j) + Character.toString(encodedChar) + s.substring(j + 1, s.length());
                }
            }
        }
        return s;
    }
}
