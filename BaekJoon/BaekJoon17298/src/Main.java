import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                A[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            A[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}
