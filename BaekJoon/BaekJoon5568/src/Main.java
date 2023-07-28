import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static int n, k;
    static int[] cards;
    static boolean[] visited;
    static HashSet<String> createdNum = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        cards = new int[n];
        visited = new boolean [n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }

        permutaion("", k);

        System.out.println(createdNum.size());
    }

    private static void permutaion(String num, int remainCnt) {
        if (remainCnt == 0) {
            createdNum.add(num);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutaion(num + cards[i], remainCnt - 1);
                visited[i] = false;
            }
        }
    }
}
