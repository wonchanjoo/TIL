import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int offset;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (offset = 1; offset < N; offset *= 2);
        tree = new long[offset * 2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                long tmp = a < b ? Sum(a - 1, b - 1) : Sum(b - 1, a - 1);
                sb.append(tmp).append('\n');
            } else {
                Modify(a - 1, b);
            }
        }

        System.out.println(sb);
    }

    private static void Modify(int idx, int value) {
        tree[idx + offset] = value;

        int parent = (idx + offset) / 2;
        while (parent >= 1) {
            tree[parent] = tree[parent * 2] + tree[parent * 2 + 1];
            parent /= 2;
        }
    }

    private static long Sum(int start, int end) {
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