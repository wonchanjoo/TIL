import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        int head = N / 100; // 뒤 두 자리를 제외한 수
        int min = 100;
        for(int i = 0; i <= 9; i++) {
            for(int j = 0; j <= 9; j++) {
                int temp = (i * 10) + j; // 뒤 두 자리
                if((head * 100 + temp) % F == 0 && temp < min) {
                    min = temp;
                }
            }
        }

        System.out.println(Integer.toString(min / 10) + Integer.toString(min % 10));
    }
}