import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] S;
    static boolean[] visited;

    static int min = Integer.MAX_VALUE; // 능력치 차이의 최솟값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, N / 2);

        System.out.println(min);
    }

    private static void dfs(int idx, int remainCnt) {
        // N / 2개의 팀을 모두 선택한 경우
        if (remainCnt == 0) {
            min = Math.min(min, score());
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, remainCnt - 1);
                visited[i] = false;
            }
        }
    }

    // 스타트팀과 링크팀의 점수 차이를 반환
    private static int score() {
        int[] start = new int[N / 2];
        int[] link = new int[N / 2];

        // 스타트팀과 링크팀 나누기
        int startIdx = 0;
        int linkIdx = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                start[startIdx++] = i;
            } else {
                link[linkIdx++] = i;
            }
        }

        // 점수 계산
        int startSum = 0;
        int linkSum = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                startSum += S[start[i]][start[j]];
                startSum += S[start[j]][start[i]];
                linkSum += S[link[i]][link[j]];
                linkSum += S[link[j]][link[i]];
            }
        }

        return Math.abs(startSum - linkSum);
    }
}