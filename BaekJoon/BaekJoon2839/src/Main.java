import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int c = N / 5; // 5kg 개수
        int remain = N - c * 5; // 남은 무게
        while(remain % 3 != 0) { // 남은 무게가 3kg의 배수가 아닌 경우
            remain += 5;
            if(remain > N) {
                c = -1;
                break;
            }
            c--;
        }
        if(c == -1) {
            System.out.println(-1);
        } else {
            c = c + remain / 3;
            System.out.println(c);
        }
    }
}
