import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int start = 0;
        int sum = 0;
        int tmp = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                sum += (Integer.parseInt(s.substring(start, i)) * tmp);
                start = i + 1;

                if (s.charAt(i) == '-') {
                    tmp = -1;
                }
            }
        }
        sum += (Integer.parseInt(s.substring(start)) * tmp);

        System.out.println(sum);
    }
}