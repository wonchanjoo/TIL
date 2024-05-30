import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int QUARTER = 25;
    static final int DIME = 10;
    static final int NICKEL = 5;
    static final int PENNY = 1;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int C = Integer.parseInt(br.readLine());
            count(C);
        }

        System.out.println(sb);
    }

    private static void count(int c) {
        if (c >= QUARTER) {
            sb.append(c / QUARTER);
            c %= QUARTER;
        } else {
            sb.append('0');
        }
        sb.append(' ');

        if (c >= DIME) {
            sb.append(c / DIME);
            c %= DIME;
        } else {
            sb.append('0');
        }
        sb.append(' ');

        if (c >= NICKEL) {
            sb.append(c / NICKEL);
            c %= NICKEL;
        } else {
            sb.append('0');
        }
        sb.append(' ');

        if (c >= PENNY) {
            sb.append(c / PENNY);
            c %= PENNY;
        } else {
            sb.append('0');
        }
        sb.append('\n');
    }
}