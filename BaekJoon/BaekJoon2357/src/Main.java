import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int offset;
    static int[] maxTree, minTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // offset 구하기
        for (offset = 1; offset < N; offset *= 2);

        // 트리 생성
        maxTree = new int[offset * 2];
        minTree = new int[offset * 2];

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            maxTree[i + offset] = n;
            minTree[i + offset] = n;
        }

        // 비어있는 노드 값 채워주기
        for (int i = offset + N; i < maxTree.length; i++) {
            maxTree[i] = Integer.MIN_VALUE;
            minTree[i] = Integer.MAX_VALUE;
        }

        // 루트까지 올라가면서 값 채워주기
        for (int i = offset - 1; i >= 1; i--) {
            maxTree[i] = Math.max(maxTree[i * 2],maxTree[i * 2 + 1]);
            minTree[i] = Math.min(minTree[i * 2], minTree[i * 2 + 1]);
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int min = getMin(start - 1, end - 1);
            int max = getMax(start - 1, end - 1);
            sb.append(min).append(' ').append(max).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static int getMin(int start, int end) {
        start += offset;
        end += offset;

        int min = Integer.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1)
                min = Math.min(min, minTree[start++]);
            if (end % 2 == 0)
                min = Math.min(min, minTree[end--]);

            start /= 2;
            end /= 2;
        }

        return min;
    }

    private static int getMax(int start, int end) {
        start += offset;
        end += offset;

        int max = Integer.MIN_VALUE;
        while (start <= end) {
            if (start % 2 == 1)
                max = Math.max(max, maxTree[start++]);
            if (end % 2 == 0)
                max = Math.max(max, maxTree[end--]);

            start /= 2;
            end /= 2;
        }

        return max;
    }
}
