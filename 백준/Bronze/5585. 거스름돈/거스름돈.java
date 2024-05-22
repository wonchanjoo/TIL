import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] coin = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());

        int count = 0;
        while(n > 0) {
            for(int i = 0; i < coin.length; i++) {
                if(n >= coin[i]) {
                    count = count + n / coin[i];
                    n %= coin[i];
                }
            }
        }


        System.out.println(count);
    }
}