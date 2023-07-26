import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static long[] tree;  // 1부터 시작하는 tree
    static int offset;  // 맨 아랫줄 시작 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(offset = 1; offset < N; offset *= 2);
        tree = new long[offset * 2 + 2]; // 2 정도 여유 있게

        for (int i = 0; i < N; i++)
            tree[offset + i] = Long.parseLong(br.readLine());

        // 구간 합 채우기
        initIndexedTree();

        for(int i = 0; i < (M + K); i++) {
            String[] command = br.readLine().split(" ");

            int b = Integer.parseInt(command[1]);
            if(command[0].equals("1")) {
                long c = Long.parseLong(command[2]);
                update(b - 1, c);
            } else {
                int c = Integer.parseInt(command[2]);
                sb.append(sum(b - 1, c - 1)).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void initIndexedTree() {
        for(int i = offset - 1; i >= 1; i--)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    private static void update(int idx, long value) {
        tree[offset + idx] = value;

        int i = (offset + idx) / 2;
        while(i >= 1) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
            i /= 2;
        }
    }

    private static long sum(int start, int end) {
        start += offset;
        end += offset;

        long sum = 0;
        while(start <= end) {
            // 시작 점이 오른쪽(홀수)인 경우
            if(start % 2 != 0) {
                sum += tree[start++];
            }
            // 끝 점이 왼쪽(짝수)인 경우
            if(end % 2 == 0) {
                sum += tree[end--];
            }

            start /= 2;
            end /= 2;
        }

        return sum;
    }
}
