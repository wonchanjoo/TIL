import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] stairs;
    static int[] before;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stairs = new int[N];
        before = new int[N];
        for(int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        before[0] = -1;
        before[1] = 0;
        for(int i = 2; i < N; i++) {
            if(before[i - 1] == i - 2) {
                before[i] = i - 2;
            } else {
                if(stairs[i - 1] > stairs[i - 2])
                    before[i] = i - 1;
                else
                    before[i] = i - 2;
            }
        }

        int i = before[N - 1];
        int sum = stairs[N - 1];
        while(i >= 0) {
            sum += stairs[i];
            i = before[i];
        }

        System.out.println(sum);
    }
}