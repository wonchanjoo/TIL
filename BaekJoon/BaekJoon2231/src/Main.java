import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int i = 1;
        while(i < N) {
            int temp = i;
            int sum = i; // 자기 자신
            while(temp != 0) { // 각 자리수의 합
                sum = sum + temp % 10;
                temp /= 10;
            }
            if(sum == N) {
                break;
            }
            i++;
        }

        if(i == N) {
            System.out.println(0);
        } else {
            System.out.println(i);
        }
    }
}
