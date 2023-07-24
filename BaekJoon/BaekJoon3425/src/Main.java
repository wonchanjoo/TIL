import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    static int[] stack = new int[10001];
    static int top = -1;

    static ArrayList<String> commandList = new ArrayList<>();
    static Deque<Integer> numberQueue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] command = br.readLine().split(" ");

            if(command[0].equals("QUIT"))  break;

            else if(command[0].equals("END")) {
                int N = Integer.parseInt(br.readLine());

                for (int i = 0; i < N; i++)
                    numberQueue.offer(Integer.parseInt(br.readLine()));

                goStack();
                sb.append('\n');

                commandList = new ArrayList<>();
                numberQueue = new ArrayDeque<>();
                br.readLine();
            }

            else if (command[0].equals("NUM"))
                commandList.add(command[1]);

            else
                commandList.add(command[0]);
        }

        System.out.println(sb);
    }

    private static void goStack() {
        while(!numberQueue.isEmpty()) {
            boolean error = false;
            top = -1; // stack init
            stack[++top] = numberQueue.poll();

            for(int i = 0; i < commandList.size(); i++) {
                if(error) {
                    sb.append("ERROR").append('\n');
                    break;
                }

                String command = commandList.get(i);

                switch (command) {
                    case "POP":
                        if (top == -1)
                            error = true;
                        else
                            top--;
                        break;
                    case "INV":
                        if (top == -1)
                            error = true;
                        else
                            stack[top] *= -1;
                        break;
                    case "DUP":
                        if (top == -1)
                            error = true;
                        else
                            stack[++top] = stack[top - 1];
                        break;
                    case "SWP":
                        if (top < 1)
                            error = true;
                        else
                            swap(top, top - 1);
                        break;
                    case "ADD":
                        if (top < 1)
                            error = true;
                        else {
                            long temp = stack[top] + stack[top - 1];
                            if(temp > 1000000000)
                                error = true;
                            else
                                stack[--top] = (int) temp;
                        }
                        break;
                    case "SUB":
                        if (top < 1)
                            error = true;
                        else
                            stack[top - 1] = stack[top - 1] - stack[top--];
                        break;
                    case "MUL":
                        if (top < 1)
                            error = true;
                        else {
                            long temp = (long) stack[top] * stack[--top];
                            if(temp > 1000000000)
                                error = true;
                            else
                                stack[top] = (int)temp;
                        }
                        break;
                    case "DIV":
                        if (top < 1 || stack[top] == 0)
                            error = true;
                        else {
                            int temp = Math.abs(stack[top - 1]) / Math.abs(stack[top]);
                            if(stack[top - 1] < 0 || stack[top] < 0)
                                stack[--top] = -temp;
                            else
                                stack[--top] = temp;
                        }
                        break;
                    case "MOD":
                        if (top < 1 || stack[top] == 0)
                            error = true;
                        else {
                            int temp = Math.abs(stack[top - 1]) % Math.abs(stack[top]);
                            if(stack[top - 1] < 0 || stack[top] < 0)
                                stack[--top] = -temp;
                            else
                                stack[--top] = temp;
                        }
                        break;
                    default:
                        stack[++top] = Integer.parseInt(command);
                        break;
                }
            }
            if(top == 0)
                sb.append(stack[top]).append('\n');
            else
                sb.append("ERROR").append('\n');
        }
    }

    private static void swap(int idx1, int idx2) {
        int temp = stack[idx1];
        stack[idx1] = stack[idx2];
        stack[idx2] = temp;
    }

    private static void printStack() {
        for(int i = 0; i <= top; i++)
            System.out.print(stack[i] + " ");
        System.out.println();
    }
}
