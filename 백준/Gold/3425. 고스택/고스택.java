import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    static final int MAX = 1_000_000_000;

    static int[] stack = new int[10001];
    static int top = -1;

    static List<String> commandList = new ArrayList<>();
    static Deque<Integer> numberQueue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String command = br.readLine();

            if(command.equals("QUIT")) {
                break;
            } else if(command.equals("END")) {
                int N = Integer.parseInt(br.readLine());

                for (int i = 0; i < N; i++) {
                    numberQueue.offer(Integer.parseInt(br.readLine()));
                }

                goStack();
                sb.append('\n');

                // 초기화
                commandList = new ArrayList<>();
                br.readLine();
            } else {
                commandList.add(command);
            }
        }

        System.out.println(sb);
    }

    private static void goStack() {
        while (!numberQueue.isEmpty()) {
            top = -1;
            boolean error = false;
            stack[++top] = numberQueue.poll();

            for (String s : commandList) {
                if (error) {
                    break;
                }

                String[] command = s.split(" ");
                switch (command[0]) {
                    case "NUM":
                        int X = Integer.parseInt(command[1]);
                        stack[++top] = X;
                        break;
                    case "POP":
                        if (isEmpty()) {
                            error = true;
                        } else {
                            top--;
                        }
                        break;
                    case "INV":
                        if (isEmpty()) {
                            error = true;
                        } else {
                            stack[top] *= -1;
                        }
                        break;
                    case "DUP":
                        if (isEmpty()) {
                            error = true;
                        } else {
                            stack[top + 1] = stack[top++];
                        }
                        break;
                    case "SWP":
                        if (size() < 2) {
                            error = true;
                        } else {
                            int tmp = stack[top];
                            stack[top] = stack[top - 1];
                            stack[top - 1] = tmp;
                        }
                        break;
                    case "ADD":
                        if (size() < 2) {
                            error = true;
                        } else {
                            long add = stack[top] + stack[top - 1];
                            if (Math.abs(add) > MAX) {
                                error = true;
                            } else {
                                stack[--top] = (int) add;
                            }
                        }
                        break;
                    case "SUB":
                        if (size() < 2) {
                            error = true;
                        } else {
                            long sub = stack[top - 1] - stack[top];
                            if (Math.abs(sub) > MAX) {
                                error = true;
                            } else {
                                stack[--top] = (int) sub;
                            }
                        }
                        break;
                    case "MUL":
                        if (size() < 2) {
                            error = true;
                        } else {
                            long mul = (long) stack[top] * stack[top - 1];
                            if (Math.abs(mul) > MAX) {
                                error = true;
                            } else {
                                stack[--top] = (int) mul;
                            }
                        }
                        break;
                    case "DIV":
                        if (size() < 2 || stack[top] == 0) {
                            error = true;
                        } else {
                            int div = stack[top - 1] / stack[top];
                            stack[--top] = div;
                        }
                        break;
                    case "MOD":
                        if (size() < 2 || stack[top] == 0) {
                            error = true;
                        } else {
                            int mod = stack[top - 1] % stack[top];
                            stack[--top] = mod;
                        }
                        break;
                }
            }

            if (error || size() != 1) {
                sb.append("ERROR\n");
            } else {
                sb.append(stack[top--]).append('\n');
            }
        }
    }

    private static boolean isEmpty() {
        return top == -1;
    }

    private static int size() {
        return top + 1;
    }
}