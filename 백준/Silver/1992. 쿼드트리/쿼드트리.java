import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(quadTree(0, 0, N));
    }

    private static String quadTree(int startR, int startC, int n) {
        boolean mix = false;

        // 0과 1이 섞여있는지 판단
        int tmp = arr[startR][startC];
        for (int r = startR; r < startR + n; r++) {
            for (int c = startC; c < startC + n; c++) {
                if (tmp != arr[r][c]) {
                    mix = true;
                    break;
                }
            }
        }

        if (mix) {
            StringBuilder sb = new StringBuilder();
            sb.append('(');

            sb.append(quadTree(startR, startC, n / 2)); // 왼쪽 위
            sb.append(quadTree(startR, startC + n / 2, n / 2)); // 오른쪽 위
            sb.append(quadTree(startR + n / 2, startC, n / 2)); // 왼쪽 아래
            sb.append(quadTree(startR + n / 2, startC + n / 2, n / 2)); // 오른쪽 아래

            sb.append(')');

            return sb.toString();
        } else {
            return Integer.toString(tmp);
        }
    }
}