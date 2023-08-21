import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MAX_HEIGHT = 1_000_000_000;

    static int N, offset;
    static int[] height;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // offset 구하기
        for (offset = 1; offset < N; offset *= 2);

        // 배열 생성
        tree = new int[offset * 2];
        height = new int[N + 1];
        height[0] = MAX_HEIGHT;

        // input
        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(br.readLine());
            tree[i + offset - 1] = i;
        }

        initTree();

        System.out.println(getMaxArea(1, N));
    }

    private static void initTree() {
        for (int i = offset - 1; i >= 1; i--) {
            tree[i] = height[tree[i * 2]] > height[tree[i * 2 + 1]] ? tree[i * 2 + 1] : tree[i * 2];
        }
    }

    // start ~ end에서 가장 큰 직사각형의 넓이를 반환한다.
    private static int getMaxArea(int start, int end) {
        int minIdx = query(start - 1, end - 1);
        int max = (end - start + 1) * height[minIdx];

        if (minIdx - 1 >= start) {
            max = Math.max(getMaxArea(start, minIdx - 1), max);
        }
        if (minIdx + 1 <= end) {
            max = Math.max(getMaxArea(minIdx + 1, end), max);
        }

        return max;
    }

    // start ~ end에서 가장 낮은 높이의 인덱스를 반환한다.
    private static int query(int start, int end) {
        start += offset;
        end += offset;

        int min = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                min = height[min] > height[tree[start]] ? tree[start] : min;
                start++;
            }
            if (end % 2 == 0) {
                min = height[min] > height[tree[end]] ? tree[end] : min;
                end--;
            }

            start /= 2;
            end /= 2;
        }

        return min;
    }
}