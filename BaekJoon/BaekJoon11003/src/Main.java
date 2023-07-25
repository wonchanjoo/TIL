import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, L;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken()); // 입력 끝

        Deque<Integer> deque = new ArrayDeque<>();
        int start = 1 - L, end = 0;
        while(end < N) {
            // 윈도우 벗어난 값 삭제
            if((start - 1) >= 0 && deque.peekFirst() == A[start - 1])
                deque.pollFirst();

            // 덱에 있는 숫자 중, 들어갈 수보다 큰 수가 있는 경우 삭제
            while(!deque.isEmpty()) {
                if(deque.peekLast() > A[end])
                    deque.pollLast();
                else    break;
            }

            deque.offerLast(A[end]);
            start++; end++;

            // 최솟값 출력
            sb.append(deque.peekFirst()).append(' ');
        }

        System.out.println(sb);
    }
}
