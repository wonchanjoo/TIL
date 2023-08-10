import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    static int N;
    static int answer = Integer.MAX_VALUE;
    static House[] houses;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        houses = new House[N];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            houses[i] = new House(r, g, b);
        }

        // dp[i][color] : i번째 집에 color를 칠할 때의 누적 최소 비용
        dp[0][RED] = houses[0].r;
        dp[0][GREEN] = houses[0].g;
        dp[0][BLUE] = houses[0].b;

        for (int i = 1; i < N; i++) {
            dp[i][RED] = Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]) + houses[i].r;
            dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + houses[i].g;
            dp[i][BLUE] = Math.min(dp[i - 1][RED], dp[i - 1][GREEN]) + houses[i].b;
        }

        answer = Math.min(dp[N - 1][RED], dp[N - 1][GREEN]);
        answer = Math.min(answer, dp[N - 1][BLUE]);
        System.out.println(answer);
    }

    static class House {
        int r, g, b;

        public House(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
}