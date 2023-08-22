import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A, sorted;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        System.out.println(answer);
    }

    private static void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    private static void merge(int left, int mid, int right) {
        int L = left;
        int R = mid + 1;
        int idx = left;

        while (L <= mid && R <= right) {
            if (A[L] <= A[R]) {
                sorted[idx++] = A[L++];
            } else {
                answer += (mid + 1 - L);
                sorted[idx++] = A[R++];
            }
        }

        // 남아있는 수 처리해주기
        while (L <= mid) {
            sorted[idx++] = A[L++];
        }
        while (R <= right) {
            sorted[idx++] = A[R++];
        }

        // 원본 배열에 복사
        for (int i = left; i <= right; i++) {
            A[i] = sorted[i];
        }
    }
}