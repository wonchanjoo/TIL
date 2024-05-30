import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] expectedRank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        expectedRank = new int[N];
        for (int i = 0; i < N; i++) {
            expectedRank[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expectedRank);

        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Math.abs((i + 1) - expectedRank[i]);
        }

        System.out.println(answer);
    }
}