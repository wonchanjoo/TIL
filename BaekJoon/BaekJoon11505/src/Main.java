import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MODULUS = 1_000_000_007;

    static int N, M, K;     // N: 수의 개수 / M: 수의 변경이 일어나는 횟수 / K: 구간의 곲을 구하는 횟수
    static int[] nums;

    static long[] tree;
    static int offset;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N];

        // 트리 생성
        for (offset = 1; offset < N; offset *= 2);
        tree = new long[offset * 2];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            tree[i + offset] = nums[i];
        }

        // 트리 값 채우기
        for (int i = offset + N; i < tree.length; i++) {
            tree[i] = 1;
        }
        for (int i = offset - 1; i >= 1; i--) {
            tree[i] = tree[i * 2] * tree[i * 2 + 1] % MODULUS;
        }

        for (int i = 0; i < (M + K); i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(b - 1, c);
            } else {
                sb.append(multiple(b - 1, c - 1)).append('\n');
            }
        }

        System.out.println(sb);
    }

    // idx의 값을 value로 변경
    private static void update(int idx, int value) {
        tree[idx + offset] = value;

        int parent = (idx + offset) / 2;
        while (parent >= 1) {
            tree[parent] = (tree[parent * 2] * tree[parent * 2 + 1]) % MODULUS;
            parent /= 2;
        }
    }

    private static long multiple(int start, int end) {
        start += offset;
        end += offset;

        long mul = 1;
        while (start <= end) {
            if (start % 2 == 1) {
                mul *= tree[start++];
                mul %= MODULUS;
            }
            if (end % 2 == 0) {
                mul *= tree[end--];
                mul %= MODULUS;
            }

            start /= 2;
            end /= 2;
        }

        return mul;
    }
}
