import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append('\n');
        }

        System.out.println(sb);
    }
}