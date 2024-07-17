import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int answer = 0;
    static int[] honey;
    static int[] sumRight;
    static int[] sumLeft;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        honey = new int[N + 1];
        sumRight = new int[N + 1];
        sumLeft = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            sumRight[i] = sumRight[i - 1] + honey[i];
        }

        for (int i = N - 1; i >= 1; i--) {
            sumLeft[i] = sumLeft[i + 1] + honey[i];
        }

        // 1. 벌 -> 벌 -> 벌통
        for (int i = 2; i < N; i++) {
            answer = Math.max(answer, (sumRight[N] - sumRight[1] - honey[i]) + (sumRight[N] - sumRight[i]));
        }

        // 2. 벌통 -> 벌 -> 벌
        for (int i = 2; i < N; i++) {
            answer = Math.max(answer, (sumLeft[1] - sumLeft[i]) + (sumLeft[1] - sumLeft[N] - honey[i]));
        }

        // 3. 벌 -> 벌통 -> 벌
        for (int i = 2; i < N; i++) {
            answer = Math.max(answer, (sumRight[i] - sumRight[1]) + (sumLeft[i] - sumLeft[N]));
        }

        System.out.println(answer);
    }
}