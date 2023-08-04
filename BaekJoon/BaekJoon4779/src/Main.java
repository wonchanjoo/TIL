import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = "";
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            int N = Integer.parseInt(s);

            int length = (int) Math.pow(3, N);
            temp = new char[length];
            for (int i = 0; i < length; i++) {
                temp[i] = ' ';
            }

            cantorianSet(0, length - 1);

            for (int i = 0; i < length; i++) {
                sb.append(temp[i]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static void cantorianSet(int start, int end) {
        if (start == end) {
            temp[start] = '-';
            return;
        }

        int length = (end - start + 1) / 3;

        cantorianSet(start, start + length - 1);
        cantorianSet(end - length + 1, end);
    }

}