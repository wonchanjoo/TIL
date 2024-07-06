import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            for (int i = 0; i <= N; i++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}