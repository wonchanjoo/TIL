import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int P = 1_500_000; // 주기
    static final int M = 1_000_000; // 나누는 수
    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());

        int[] fibo = new int[(int)(n % P) + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i < fibo.length; i++){
            fibo[i] = (fibo[i - 2] + fibo[i - 1]) % M;
        }

        System.out.println(fibo[(int)(n % P)]);
    }
}
