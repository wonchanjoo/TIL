import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1_000_000_007;
    static int N;
    static long[] fac;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        fac = new long[N + 1];

        fac[1] = 1;
        for (int i = 2; i <= N; i++) {
            fac[i] = (fac[i - 1] * i) % MOD;
        }

        System.out.println((fac[N] * fac[N - 1]) % MOD);
    }
}