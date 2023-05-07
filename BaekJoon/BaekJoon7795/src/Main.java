import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] A = new int[Integer.parseInt(st.nextToken())];
            int[] B = new int[Integer.parseInt(st.nextToken())];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < B.length; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            for(int i = 0; i < A.length; i++) {
                for(int j = 0; j < B.length; j++) {
                    if(A[i] > B[j]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb.toString());
    }
}
