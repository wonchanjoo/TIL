import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());

        int N = 0;
        long sum = 0;
        for (long i = 1; i <= S; i++) {
            if (sum + i <= S) {
                sum += i;
                N++;
            } else {
                break;
            }
        }

        System.out.println(N);
    }
}