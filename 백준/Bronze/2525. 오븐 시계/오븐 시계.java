import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()) * 60;
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());

        int sum = A + B + C;
        System.out.println((sum / 60 % 24) + " " + (sum % 60));
    }
}