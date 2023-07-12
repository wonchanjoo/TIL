import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] count = new int[3];
        while(T >= 10) {
            if (T >= 300) {
                count[0] += T / 300;
                T %= 300;
            } else if (T >= 60) {
                count[1] += T / 60;
                T %= 60;
            } else {
                count[2] += T / 10;
                T %= 10;
            }
        }

        if(T > 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 3; i++)
                sb.append(count[i]).append(' ');
            System.out.println(sb);
        }
    }
}