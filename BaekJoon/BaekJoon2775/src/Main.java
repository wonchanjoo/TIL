import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] apart = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < 15; i++) {
            apart[0][i] = i;
        }

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(getPeopleCount(k, n)).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static int getPeopleCount(int k, int n) {
        if(apart[k][n] > 0) {
            return apart[k][n];
        }

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += getPeopleCount(k - 1, i);
        }

        return sum;
    }
}
