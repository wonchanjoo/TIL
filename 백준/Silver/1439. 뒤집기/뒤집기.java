import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String s;
    static int[] count = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        count[s.charAt(0) - '0']++;
        for (int i = 1; i < s.length(); i++) {
            char pre = s.charAt(i - 1);
            char cur = s.charAt(i);

            if (pre != cur) {
                count[cur - '0']++;
            }
        }

        System.out.println(Math.min(count[0], count[1]));
    }
}