import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] ropes = new Integer[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }  // 입력 끝

        Arrays.sort(ropes, Collections.reverseOrder());
        int max = 0;
        for(int i = 0; i < N; i++) {
            int temp = ropes[i] * (i + 1);
            if(temp > max)
                max = temp;
        }

        System.out.println(max);
    }
}