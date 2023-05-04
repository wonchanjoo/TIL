import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        String A = br.readLine();
        String B = br.readLine();

        for(int i = 0; i < 8; i++) {
            sb.append(Character.toString(A.charAt(i)));
            sb.append(Character.toString(B.charAt(i)));
        }

        while(sb.length() > 2) {
            temp.delete(0, temp.length()); // temp 초기화
            for(int i = 0; i < sb.length() - 1; i++) {
                int a = sb.charAt(i) - '0';
                int b = sb.charAt(i + 1) - '0';
                temp.append(Integer.toString(getRestOfSum(a, b)));
            }

            sb = new StringBuilder(temp);
        }

        System.out.println(sb.toString());
    }

    private static int getRestOfSum(int a, int b) {
        int sum = a + b;
        return sum % 10;
    }
}
