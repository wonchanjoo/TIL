import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String[] str = new String[2];
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str[0] = br.readLine();
        str[1] = br.readLine();

        dp = new int[str[0].length() + 1][str[1].length() + 1];

        int max = 0;
        for (int i = 1; i <= str[0].length(); i++) {
            for (int j = 1; j <= str[1].length(); j++) {
                if (str[1].charAt(j - 1) == str[0].charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }

        System.out.println(max);
    }
}