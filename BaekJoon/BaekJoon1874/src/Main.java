import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+\n");

            if (stack.peek() == A[index]) {
                while(true) {
                    stack.pop();
                    sb.append("-\n");
                    index++;
                    if(stack.isEmpty() || index == n || stack.peek() != A[index])
                        break;
                }
            }
        }

        if(stack.isEmpty())
            System.out.println(sb.toString());
        else
            System.out.println("NO");
    }
}
