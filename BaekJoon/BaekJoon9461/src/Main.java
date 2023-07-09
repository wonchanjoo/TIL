import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] test = new int[T];
        for (int i = 0; i < T; i++) {
            test[i] = Integer.parseInt(br.readLine());
        } // 입력 끝

        long[] P = new long[101];

        // P[1] ~ P[5]
        for(int i = 1; i <= 3; i++)
            P[i] = 1;
        for(int i = 4; i <= 5; i++)
            P[i] = 2;

        int max = Arrays.stream(test).max().orElseThrow();
        for(int i = 6; i <= max; i++)
            P[i] = P[i - 1] + P[i - 5];

        for(int i = 0; i < T; i++)
            sb.append(P[test[i]]).append('\n');
        System.out.println(sb);

    }
}