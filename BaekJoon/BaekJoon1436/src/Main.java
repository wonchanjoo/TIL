import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int i = 666;
        int count = 0;
        while(true) {
            if(have6(i))
                count++;
            if(count == N)
                break;
            i++;
        }

        System.out.println(i);
    }

    private static boolean have6(int n) {
        int count = 0;

        while(n != 0) {
            if(n % 10 == 6)
                count++;
            else
                count = 0;

            if(count >= 3)
                return true;

            n /= 10;
        }
        return false;
    }
}