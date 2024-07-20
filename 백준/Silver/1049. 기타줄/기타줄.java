import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int packagePrice = 1000;
    static int price = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            packagePrice = Math.min(packagePrice, Integer.parseInt(st.nextToken()));
            price = Math.min(price, Integer.parseInt(st.nextToken()));
        }

        int answer = Integer.MAX_VALUE;
        // 1. 패키지로 다 사는 경우
        answer = Math.min(answer, (N / 6 + 1) * packagePrice);

        // 2. 낱개로 다 사는 경우
        answer = Math.min(answer, N * price);

        // 3. 패키지 + 낱개로 사는 경우
        int tmp = (N / 6) * packagePrice;
        answer = Math.min(answer, tmp + (N % 6 * price));

        System.out.println(answer);
    }
}