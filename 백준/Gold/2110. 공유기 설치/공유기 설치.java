import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, C;
    static int[] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int L = 1;
        int R = home[N - 1] - home[0] + 1;

        while (L < R) {
            int mid = (L + R) / 2;

            if (install(mid) < C) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(R - 1);
    }

    // 설치할 수 있는 공유기 갯수 반환
    private static int install(int mid) {
        int count = 1;
        int lastInstall = home[0];

        for (int i = 1; i < N; i++) {
            if (home[i] - lastInstall >= mid) {
                count++;
                lastInstall = home[i];
            }
        }

        return count;
    }
}