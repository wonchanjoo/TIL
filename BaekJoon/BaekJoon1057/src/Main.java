import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());

        int round = 0;
        while(N > 0) {
            if(N % 2 != 0)
                N++;
            if(kim % 2 != 0)
                kim++;
            if(lim % 2 != 0)
                lim++;

            round++;
            N /= 2;
            kim /= 2;
            lim /= 2;
            if(kim == lim)
                break;
        }

        System.out.println(round);
    }
}