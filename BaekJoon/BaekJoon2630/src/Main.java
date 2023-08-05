import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static boolean[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        paper = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    paper[i][j] = true;
                } else {
                    paper[i][j] = false;
                }
            }
        }

        division(0, 0, N - 1, N - 1);

        System.out.println(white);
        System.out.println(blue);

        br.close();
    }

    private static void division(int startR, int startC, int endR, int endC) {
        boolean isOneColor = true;

        //  모두 같은 색을 가지는지 확인
        boolean color = paper[startR][startC];
        for (int i = startR; i <= endR; i ++) {
            for (int j = startC; j <= endC; j ++) {
                if (paper[i][j] != color) {
                    isOneColor = false;
                    i = endR;
                    break;
                }
            }
        }

        // 모두 같은 색을 갖는 경우, 흰색 파란색
        if (isOneColor) {
            if (paper[startR][startC])
                blue++;
            else
                white++;
            return;
        }

        int midR = (startR + endR) / 2;
        int midC = (startC + endC) / 2;

        division(startR, startC, midR, midC);
        division(startR, midC + 1, midR, endC);
        division(midR + 1, startC, endR, midC);
        division(midR + 1, midC + 1, endR, endC);
    }
}