import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int count = 0;
        for(int i = 2; i < N; i++) {
            for(int j = 0; j < i; j++) {
                for(int k = j + 1; k < i; k++) {
                    if(A[i] == (A[j] + A[k])) {
                        count++;
                        break;
                    }
                    else if(A[i] < (A[j] + A[k]))
                        break;
                }
            }
        }

        System.out.println(count);
    }
}
