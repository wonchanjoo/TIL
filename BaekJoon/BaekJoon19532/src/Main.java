import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[6]; // a b c d e f

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x = -999; x <= 999; x++)
            for(int y = -999; y <= 999; y++)
                if(isRight(x, y)) {
                    System.out.println(x + " " + y);
                    x = 1000;
                    break;
                }
    }

    private static boolean isRight(int x, int y) {
        return (arr[0] * x + arr[1] * y == arr[2] && arr[3] * x + arr[4] * y == arr[5]);
    }
}