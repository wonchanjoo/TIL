import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if(n == 1 || n == 3) {
            System.out.println("-1");
            return;
        }

        int count5won = n / 5;
        if((n - 5 * count5won) % 2 != 0) {
            count5won--;
        }
        int count2won = (n - count5won * 5) / 2;
        System.out.println(count5won + count2won);
    }
}
