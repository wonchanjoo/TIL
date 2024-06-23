import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static String M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = br.readLine();

        for (int i = 2; i >= 0; i--) {
            int tmp = M.charAt(i) - '0';
            sb.append(N * tmp).append('\n');
        }
        sb.append(N * Integer.parseInt(M));

        System.out.println(sb);
    }
}