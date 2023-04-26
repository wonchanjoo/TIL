import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            if(stack.isEmpty() || prices[stack.peek()] <= prices[i]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                    result[stack.peek()] = i - stack.pop();
                }
                stack.push(i);
            }
        }
        
        int top = -1;
        if(!stack.isEmpty()) {
            top = stack.peek();
        }
        while(!stack.isEmpty()) {
            result[stack.peek()] = top - stack.pop();
        }
        
        return result;
    }
}