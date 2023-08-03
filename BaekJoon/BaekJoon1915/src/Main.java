import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dp = new int[n][m];

        // input
        int maxLen = 0;
        for (int r = 0; r < n; r++) {
            String s = br.readLine();
            for (int c = 0; c < m; c++) {
                arr[r][c] = s.charAt(c) - '0';
                dp[r][c] = arr[r][c];
                if (arr[r][c] == 1) maxLen = 1;
            }
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {

                // 내가 1인 경우에만 정사각형을 만들 수 있다.
                if (arr[r][c] == 1) {
                    int up = dp[r - 1][c];
                    int left = dp[r][c - 1];
                    int min = Math.min(up, left);

                    if (arr[r - min][c - min] == 1) {
                        dp[r][c] = min + 1;
                    } else {
                        dp[r][c] = min;
                    }

                    // 가장 큰 정사각형의 한 변 찾기
                    if (dp[r][c] > maxLen) {
                        maxLen = dp[r][c];
                    }
                }

            }
        }

        // 넓이를 출력해야 하므로 곱해서 출력한다.
        System.out.println(maxLen * maxLen);
    }
}
