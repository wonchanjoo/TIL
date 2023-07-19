import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] stairs;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stairs = new int[N];
        D = new int[N];
        for(int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        } // 입력 끝

        D[0] = stairs[0];
        D[1] = stairs[0] + stairs[1];

        boolean cont = true;
        for(int i = 3; i < N; i++) {
            if(cont) {
                D[i] = D[i - 2] + stairs[i];
                cont = false;
            }
            else {
                if(D[i - 2] > D[i - 1])
                    D[i] = D[i - 2] + stairs[i];
                else {
                    D[i] = D[i - 1] + stairs[i];
                    cont = true;
                }
            }
        }

        System.out.println(D[N - 1]);
    }
}