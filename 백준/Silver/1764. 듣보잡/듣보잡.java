import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static Set<String> hashSet = new HashSet<>();
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (hashSet.contains(s)) {
                answer.add(s);
            }
        }

        Collections.sort(answer);

        sb.append(answer.size()).append('\n');
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}