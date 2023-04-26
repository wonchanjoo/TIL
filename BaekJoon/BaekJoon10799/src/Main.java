import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<Integer> laser = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                if(i < s.length() - 1 && s.charAt(i + 1) == ')') { // 레이저
                    laser.add(i);
                    i++;
                } else {
                    stack.push(i);
                }
            } else {
                answer += getStickCount(i);
            }
        }

        System.out.println(answer);
    }

    private static int getStickCount(int i) {
        int j;
        int k = stack.pop();
        for(j = 0; j < laser.size(); j++) {
            if(laser.get(j) > k) {
                break;
            }
        }

        return laser.size() - j + 1;
    }
}
