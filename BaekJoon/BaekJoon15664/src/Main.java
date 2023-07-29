import java.io.*;
import java.util.*;

public class Main {


    static int N, M;
    static int[] nums;
    static boolean[] visited;
    static HashSet<String> hashSet = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        select("", M, 0);
        System.out.println(sb);
    }

    private static void select(String s, int remainCnt, int idx) {
        if (idx > N)		return;

        if (remainCnt <= 0) {
            if (!hashSet.contains(s)) {
                hashSet.add(s);
                sb.append(s.trim()).append('\n');
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                select(s + nums[i] + " ", remainCnt - 1, i + 1);
                visited[i] = false;
            }
        }
    }
}