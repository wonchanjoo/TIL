import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] tree;
    static int offset;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // offset 초기화
        for (offset = 1; offset < N; offset *= 2);

        // 트리 생성
        tree = new int[offset * 2];

        for (int i = 0; i < N; i++) {
            tree[offset + i] = Integer.parseInt(br.readLine());
        }

        // 비어있는 칸은 MAX 값으로 채워준다.
        for (int i = offset + N; i < tree.length; i++) {
            tree[i] = Integer.MAX_VALUE;
        }

        // 루트까지 올라가면서 트리를 초기화한다.
        for (int i = offset - 1; i >= 1; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int min = getMin(start - 1, end - 1);
            sb.append(min).append('\n');
        }

        System.out.println(sb);
    }

    private static int getMin(int start, int end) {
        start += offset;
        end += offset;

        int min = Integer.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1)
                min = Math.min(tree[start++], min);
            if (end % 2 == 0)
                min = Math.min(tree[end--], min);

            start /= 2;
            end /= 2;
        }

        return min;
    }
}
