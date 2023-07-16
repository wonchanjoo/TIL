import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        Integer[] arr = new Integer[N.length()];

        long sum = 0;
        for(int i = 0; i < N.length(); i++) {
            int n = Integer.parseInt(N.substring(i, i + 1));
            sum += n;
            arr[i] = n;
        }

        if (!N.contains("0") || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            Arrays.sort(arr, Collections.reverseOrder());
            for(int i = 0; i < arr.length; i++)
                sb.append(arr[i]);
            System.out.println(sb);
        }

    }
}