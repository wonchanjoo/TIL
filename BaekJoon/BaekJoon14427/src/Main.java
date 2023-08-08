import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int offset;
    static int[] nums;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        // offset 설정, 트리 생성
        for (offset = 1; offset < N; offset *= 2);
        tree = new int[offset * 2];
        nums = new int[N + 1];

        nums[0] = Integer.MAX_VALUE; // 빈 칸에서 사용
        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i< N; i++) {
            nums[i + 1] = Integer.parseInt(st.nextToken());
            tree[i + offset] = i + 1;
        }

        // 트리 채우기
        for (int i = offset + N; i < tree.length; i++) {
            tree[i] = 0;
        }

        for (int i = offset - 1; i >= 1; i--) {
            int left = tree[i * 2];
            int right = tree[i * 2 + 1];

            if (nums[left] < nums[right]) {
                tree[i] = left;
            } else if (nums[left] > nums[right]) {
                tree[i] = right;
            } else {
                tree[i] = Math.min(left, right);
            }
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());

            if (query == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                update(idx, value);
            } else {
                sb.append(query()).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static int query() {
        return tree[1];
    }

    private static void update(int idx, int value) {
        nums[idx] = value;

        int parent = (idx + offset - 1) / 2;
        while (parent >= 1) {
            int left = tree[parent * 2];
            int right = tree[parent * 2 + 1];

            if (nums[left] < nums[right]) {
                tree[parent] = left;
            } else if (nums[left] > nums[right]) {
                tree[parent] = right;
            } else {
                tree[parent] = Math.min(left, right);
            }
            parent /= 2;
        }
    }
}