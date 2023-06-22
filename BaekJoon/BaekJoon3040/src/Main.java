import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(sum - (arr[i] + arr[j]) == 100) {
                    arr[i] = -1;
                    arr[j] = -1;
                    i = 9;
                    break;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            if(arr[i] != -1)
                sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
}