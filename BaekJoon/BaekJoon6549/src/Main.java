import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_HEIGHT = 1_000_000_001;

    static int n, offset;
    static int[] height;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            // offset 구하기
            for (offset = 1; offset < n; offset *= 2);

            // 트리 생성
            tree = new int[offset * 2];
            height = new int[n + 1];
            height[n] = MAX_HEIGHT;

            for (int i = 0; i < n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
                tree[i + offset] = i;
            }

            initTree();

            sb.append(getMaxArea(0, n - 1)).append('\n');
        }

        System.out.println(sb);
    }

    static void initTree() {
        for (int i = offset + n; i < tree.length; i++) {
            tree[i] = n;
        }

        for (int i = offset - 1; i >= 1; i--) {
            tree[i] = height[tree[i * 2]] > height[tree[i * 2 + 1]] ? tree[i * 2 + 1] : tree[i * 2];
        }
    }

    // start ~ end 에서 높이가 가장 낮은 막대의 인덱스를 반환한다.
    static int query(int start, int end) {
        start += offset;
        end += offset;

        int minIdx = n;
        while (start <= end) {
            if (start % 2 == 1) {
                minIdx = height[minIdx] < height[tree[start]] ? minIdx : tree[start];
                start++;
            }
            if (end % 2 == 0) {
                minIdx = height[minIdx] < height[tree[end]] ? minIdx : tree[end];
                end--;
            }

            start /= 2;
            end /= 2;
        }

        return minIdx;
    }

    static long getMaxArea(int start, int end) {
        int minIdx = query(start, end);
        long max = (long) (end - start + 1) * height[minIdx];

        // 왼쪽 막대 존재 여부
        if (start <= minIdx - 1) {
            max = Math.max(max, getMaxArea(start, minIdx - 1));
        }

        // 오른쪽 막대 존재 여부
        if (minIdx + 1 <= end) {
            max = Math.max(max, getMaxArea(minIdx + 1, end));
        }

        return max;
    }
}