import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String S;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        S = br.readLine();
        arr = new String[S.length()];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = S.substring(i);
        }

        Arrays.sort(arr);

        for (String i : arr) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}