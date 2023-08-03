import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Matrix[] matrix;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        matrix = new Matrix[N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[i] = new Matrix(r, c);
        }

        System.out.println(getMinCount(0, N - 1));
    }

    private static int getMinCount(int start, int end) {
        // 같은 경우 곱셈을 할 수 없다.
        if (start == end) {
            return 0;
        }

        // 이미 계산한 경우 같은 작업하지 않도록 반환
        if (dp[start][end] > 0) {
            return dp[start][end];
        }

        // 곱셈 연산의 횟수를 최솟값으로 만드는 k 찾기
        int min = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            min = Math.min(min, getMinCount(start, k) + getMinCount(k + 1, end) + matrix[start].row * matrix[k].column * matrix[end].column);
        }

        return dp[start][end] = min;
    }

    static class Matrix {
        int row, column;

        public Matrix(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
