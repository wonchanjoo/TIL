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

        Stack<Integer> stack = new Stack();
        int p;
        for (int i = 0; i < N; i++) {
            stack.clear();
            p = -1;

            for (int j = i + 1; j < N; j++) {
                if (A[i] < A[j]) {
                    stack.push(A[j]);
                }
            }

            if (!stack.isEmpty()) {
                p = stack.get(0);
            }

            sb.append(p + " ");
        }

        System.out.println(sb.toString());
    }
}
