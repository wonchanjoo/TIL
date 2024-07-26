import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int[] tmp = new int[end - start + 1];
            int idx = 0;
            for (int j = end; j >= start; j--) {
                tmp[idx++] = arr[j];
            }

            idx = 0;
            for (int j = start; j <= end; j++) {
                arr[j] = tmp[idx++];
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }
}