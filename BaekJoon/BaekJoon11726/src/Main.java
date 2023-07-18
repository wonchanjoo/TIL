import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 입력 끝

        D = new int[1001];
        D[1] = 1;
        D[2] = 2;

        for(int i = 3; i <= n; i++)
            D[i] = (D[i - 2] + D[i - 1]) % 10007;

        System.out.println(D[n]);
    }
}
