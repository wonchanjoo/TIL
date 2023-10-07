import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine()); // 덤프 횟수
            int[] arr = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                // 평탄화가 완료된 경우
                if (arr[99] - arr[0] <= 1) {
                    break;
                }

                arr[0]++;
                arr[99]--;

                // 앞 정렬
                for (int j = 1; j < 100; j++) {
                    if (arr[j] >= arr[j - 1]) {
                        break;
                    }

                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }

                // 뒤 정렬
                for (int j = 98; j >= 0; j--) {
                    if (arr[j] <= arr[j + 1]) {
                        break;
                    }

                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

            sb.append('#').append(t).append(' ').append(arr[99] - arr[0]).append('\n');
        }

        System.out.println(sb);
    }
}