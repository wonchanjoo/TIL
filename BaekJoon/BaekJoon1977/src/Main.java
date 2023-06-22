import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int min = -1;
        int sum = 0;
        for(int i = 1; (i * i) <= N; i++) {
            int temp = i * i;
            if(temp >= M) {
                if(min == -1)
                    min = temp;
                sum += temp;
            }
        }

        if(min == -1)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}