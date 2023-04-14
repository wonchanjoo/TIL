import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int sum = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr = new int[9];
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        boolean find = false;
        for(int i = 0; i < 9; i++) {
            if(find) {
                break;
            }
            for(int j = i + 1; j < 9; j++) {
                if (sum - (arr[i] + arr[j]) == 100) {
                    arr[i] = -1;
                    arr[j] = -1;
                    find = true;
                    break;
                }
            }
        }
        Arrays.sort(arr);

        for(int i = 0; i < 9; i++) {
            if(arr[i] != -1) {
                sb.append(arr[i]).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
