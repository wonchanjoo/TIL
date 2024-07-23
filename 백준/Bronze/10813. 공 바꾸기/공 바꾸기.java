import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] ball;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ball = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            ball[i] = i;
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int tmp = ball[i];
            ball[i] = ball[j];
            ball[j] = tmp;

        }

        for (int i = 1; i <= N; i++) {
            sb.append(ball[i]).append(' ');
        }
        System.out.println(sb);
    }
}