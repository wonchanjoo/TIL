import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
수 N개가 주어졌을 때 i 번째 수에서 j 번째 수까지의 합을 구하는 프로그램을 작성하시오
입력: 1번째 줄에 수의 개수 N(1 <= N <= 100,000), 합을 구해야 하는 횟수M(1 <= M <= 100,000),
     2번째 줄에 N개의 수가 주어진다. 각 수는 1,000보다 작거나 같은 자연수다. 3번째 줄부터는 M개의 줄에 합을 구해야하는 구간 i와 j가 주어진다.
출력: 총 M개의 줄에 입력으로 주어진 i번째 수에서 j번째 수까지의 합을 출력한다.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for(int k=0; k<M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(S[j] - S[i - 1] + "\n");
        }

        System.out.println(sb.toString());
    }
}
