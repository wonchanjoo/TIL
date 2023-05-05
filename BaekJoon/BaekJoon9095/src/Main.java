import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] count = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        count[1] = 1;
        count[2] = 2;
        count[3] = 4;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(getCount(n)).append('\n');
        }

        System.out.println(sb.toString());
    }

    // count[n] = count[n-1] + count[n-2] + count[n-3]
    private static int getCount(int n) {
        if(count[n] > 0)
            return count[n];

        return getCount(n - 1) + getCount(n - 2) + getCount(n - 3);
    }
}
