import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static long[] tree;
    static int offset;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // 인덱스 트리 생성
        for (offset = 1; offset < N; offset *= 2);
        tree = new long[offset * 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i + offset] = Integer.parseInt(st.nextToken());
        }

        // 트리 값 채우기
        for (int i = offset - 1; i >= 1; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long tmp = x > y ? sum(y - 1, x - 1) : sum(x - 1, y - 1);
            sb.append(tmp).append('\n');
            update(a - 1, b);
        }

        System.out.println(sb);
    }

    private static void update(int idx, int value) {
        tree[idx + offset] = value;

        int parent = (idx + offset) / 2;
        while (parent >= 1) {
            tree[parent] = tree[parent * 2] + tree[parent * 2 + 1];
            parent /= 2;
        }
    }

    private static long sum(int start, int end) {
        start += offset;
        end += offset;

        long sum = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                sum += tree[start++];
            }
            if (end % 2 == 0) {
                sum += tree[end--];
            }

            start /= 2;
            end /= 2;
        }

        return sum;
    }
}
