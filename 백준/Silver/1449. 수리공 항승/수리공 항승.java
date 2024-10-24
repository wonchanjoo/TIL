import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 물이 새는 위치 오름차순 정렬
        Arrays.sort(arr);

        // 2. 모든 위치를 막을 때까지 반복
        int start = arr[0];
        int answer = 1;
        for (int i = 1; i < N; i++) {
            if (start + L <= arr[i]) {
                answer++;
                start = arr[i];
            }
        }

        System.out.println(answer);
    }
}