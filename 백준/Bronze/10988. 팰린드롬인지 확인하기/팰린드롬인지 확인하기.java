import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int start = 0;
        int end = s.length() - 1;
        int answer = 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                answer = 0;
                break;
            }

            start++;
            end--;
        }


        System.out.println(answer);
    }
}