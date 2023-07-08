import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] fibo = new int[41][2];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] test = new int[T];
        for (int i = 0; i < T; i++) {
            test[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(test).max().orElseThrow();

        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        for(int i = 2; i <= max; i++) {
            fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
            fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
        }

        for(int i = 0; i < T; i++)
            sb.append(fibo[test[i]][0]).append(' ').append(fibo[test[i]][1]).append('\n');
        System.out.println(sb);
    }

}