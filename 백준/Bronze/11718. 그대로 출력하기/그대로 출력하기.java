import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = "";
        while ((s = br.readLine()) != null) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}