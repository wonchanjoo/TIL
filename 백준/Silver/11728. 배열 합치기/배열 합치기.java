import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int idxA = 0;
        int idxB = 0;
        while (idxA < N && idxB < M) {
            if (A[idxA] < B[idxB]) {
                sb.append(A[idxA++] + " ");
            } else {
                sb.append(B[idxB++] + " ");
            }
        }

        while (idxA < N) {
            sb.append(A[idxA++] + " ");
        }
        while (idxB < M) {
            sb.append(B[idxB++] + " ");
        }

        System.out.println(sb);
    }
}