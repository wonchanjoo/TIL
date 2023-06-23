import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int min = 0;
        for(int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;
            if(Math.abs(100 - min) > Math.abs(100 - sum))
                min = sum;
            else if(Math.abs(100 - min) == Math.abs(100 - sum))
                min = Math.max(min, sum);
        }

        System.out.println(min);
    }
}