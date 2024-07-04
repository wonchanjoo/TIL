import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (isPrimeNumber(Integer.parseInt(st.nextToken()))) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPrimeNumber(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= (n / 2); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}