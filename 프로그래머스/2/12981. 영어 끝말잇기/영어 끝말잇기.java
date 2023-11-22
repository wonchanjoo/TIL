import java.util.Stack;

class Solution {
    public int[] solution(int n, String[] words) {
        Stack<String> stack = new Stack<>();
        
        int round = 1;
        int i = 0;
        int turn = 1;
        
        stack.push(words[i++]);
        System.out.println(turn + ": " + stack.peek());
        turn++;
        while(true) {
            if(i == words.length)
                break;
            
            // 이전에 등장했던 단어인 경우
            if(stack.contains(words[i])) {
                int[] result = {turn, round};
                return result;
            }
            // 전 단어의 끝으로 시작하지 않는 경우
            if(stack.peek().charAt(stack.peek().length() - 1) != words[i].charAt(0)) {
                int[] result = {turn, round};
                return result;
            }
            
            // 단어 말하기(push)
            stack.push(words[i++]);
            System.out.println(turn + ": " + stack.peek());
            
            // 다음 사람으로 넘어가기
            turn++;
            if(turn == (n + 1)) {
                turn = 1;
            }
            
            // 다음 사람이 첫번째 사람이면 다음 round
            if(turn == 1) {
                round++;
            }
        }
        int[] result = {0, 0};
        return result;
    }
}