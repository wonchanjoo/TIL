import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int answer = 1;
    static int[] fac, VIP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        fac = new int[N + 1];

        M = Integer.parseInt(br.readLine());
        VIP = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            VIP[i] = Integer.parseInt(br.readLine());
            answer *= factorial(VIP[i] - VIP[i - 1]);
        }

        System.out.println(answer);
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return n;
        }
        if (fac[n] > 0) {
            return fac[n];
        }

        return fac[n] = n * factorial(n - 1);
    }
}