import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        coins = new int[N];
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(br.readLine()); // 입력 끝

        int count = 0;
        for(int i = N - 1; i >= 0; i--)
            if(K >= coins[i]) {
                count += K / coins[i];
                K %= coins[i];
            }

        System.out.println(count);
    }
}