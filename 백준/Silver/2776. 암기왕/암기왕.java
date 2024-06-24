import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, N, M;
    static Set<Integer> scheduler1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            scheduler1 = new HashSet<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scheduler1.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int m = Integer.parseInt(st.nextToken());
                if (scheduler1.contains(m)) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}