import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean turn = true; // false = 상근, true = 창영
        while(N > 0) {
            turn = !turn;
            if(N >= 3) {
                N -= 3;
            } else {
                N--;
            }
        }

        if(turn) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
