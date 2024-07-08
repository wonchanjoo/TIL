import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static int t, n;
    static BigInteger[] dp = new BigInteger[68];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append(check(n)).append('\n');
        }

        System.out.println(sb);
    }

    private static BigInteger check(int i) {
        if (dp[i] != null) {
            return dp[i];
        }
        if (i < 2) {
            return dp[i] = new BigInteger("1");
        }
        if (i == 2) {
            return dp[i] = new BigInteger("2");
        }
        if (i == 3) {
            return dp[i] = new BigInteger("4");
        }

        BigInteger sum = BigInteger.ZERO;
        for (int j = 1; j <= 4; j++) {
            sum = sum.add(check(i - j));
        }
        return dp[i] = sum;
    }
}