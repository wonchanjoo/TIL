import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int K = Integer.parseInt(nums[1]);

        int count = 0;
        int i;
        for(i = 1; i <= N / 2; i++) {
            if(N % i == 0) {
                count++;
                if(count == K) {
                    break;
                }
            }
        }

        if((count + 1) == K) {
            System.out.println(N);
        } else if(count == K) {
            System.out.println(i);
        } else {
            System.out.println(0);
        }
    }
}