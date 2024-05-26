import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int X, Y, W, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        long answer = 0;
        // 대각선 이동
        int tmp = Math.min(W * 2, S);
        answer += (long) Math.min(X, Y) * tmp;

        // 나머지 이동(짝수)
        tmp = Math.abs(X - Y) / 2;
        answer += (long) tmp * Math.min(W, S) * 2;

        // 나머지 이동(홀수)
        tmp = Math.abs(X - Y) % 2;
        answer += tmp * W;

        System.out.println(answer);
    }
}