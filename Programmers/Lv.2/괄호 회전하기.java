import java.util.Stack;

class Solution {
    public int solution(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            s = rotateStringToLeft(s);
            if(isRightString(s)) {
                result++;
            }
        }
        return result;
    }
    
    boolean isRightString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty())
                    return false;
                else if(stack.pop() != '(')
                    return false;
            } else if(c == '}') {
                if(stack.isEmpty())
                    return false;
                else if(stack.pop() != '{')
                    return false;
            } else if(c == ']') {
                if(stack.isEmpty())
                    return false;
                else if(stack.pop() != '[')
                    return false;
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    String rotateStringToLeft(String s) {
        String rotated = s.substring(1, s.length()) + s.substring(0, 1);
        return rotated;
    }
}