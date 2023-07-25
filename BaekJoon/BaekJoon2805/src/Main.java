import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] trees;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        int L = 0, R = 0;
        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            R = Math.max(trees[i], R); // 이분 탐색의 범위
        } // 입력 끝

        // 이분 탐색 시작
        while(L <= R) {
            int mid = (L + R) / 2;

            if(cut(mid)) {
                answer = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean cut(int m) {
        long sum = 0;

        for(int tree: trees)
            if(tree > m)
                sum += tree - m;

        return sum >= M;
    }
}
