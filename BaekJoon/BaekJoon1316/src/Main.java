import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] check = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            char temp = ' ';
            boolean isGroup = true;
            initCheck();

            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(check[c - 'a'] && temp != c) {
                    isGroup = false;
                    break;
                } else {
                    check[c - 'a'] = true;
                }
                temp = c;
            }
            if(isGroup) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void initCheck() {
        Arrays.fill(check, false);
    }
}
