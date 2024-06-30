import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] num = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        if (num[0] == num[1] && num[1] == num[2]) {
            answer = 10000 + num[0] * 1000;
        } else if (num[0] == num[1]) {
            answer = 1000 + num[0] * 100;
        } else if (num[1] == num[2]) {
            answer = 1000 + num[1] * 100;
        } else if (num[0] == num[2]) {
            answer = 1000 + num[0] * 100;
        } else {
            int max = Integer.max(num[0], num[1]);
            max = Integer.max(max, num[2]);
            answer = max * 100;
        }

        System.out.println(answer);
    }
}