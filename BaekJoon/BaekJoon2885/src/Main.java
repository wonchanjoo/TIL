import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        // 가장 작은 초콜릿의 크기
        int size;
        for (size = 1; size < K; size *= 2);
        sb.append(size).append(' ');

        int cnt = 0;
        while (K > 0) {
            if (K >= size) {
                K -= size;
            } else {
                size /= 2;
                cnt++;
            }
        }

        sb.append(cnt);
        System.out.println(sb);
    }
 }