import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] != idx) {
                stack.push(arr[i]);
            } else {
                idx++;
                while (!stack.isEmpty() && stack.peek() == idx) {
                    stack.pop();
                    idx++;
                }
            }
        }

        String answer = "Nice";
        while (!stack.isEmpty()) {
            if (stack.pop() != idx) {
                answer = "Sad";
                break;
            } else {
                idx++;
            }
        }

        System.out.println(answer);
    }
}