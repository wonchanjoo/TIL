import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] stack = new int[1_000_000];
    static int top = -1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push":
                    push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "top":
                    top();
                    break;
            }
        }

        System.out.println(sb);
    }

    private static void push(int X) {
        stack[++top] = X;
    }

    private static void pop() {
        if(top == -1)
            sb.append(-1).append('\n');
        else
            sb.append(stack[top--]).append('\n');
    }

    private static void size() {
        sb.append(top + 1).append('\n');
    }

    private static void empty() {
        if(top == -1)
            sb.append(1).append('\n');
        else
            sb.append(0).append('\n');
    }

    private static void top() {
        if(top == -1)
            sb.append(-1).append('\n');
        else
            sb.append(stack[top]).append('\n');
    }
}
