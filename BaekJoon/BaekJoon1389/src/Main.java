import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[][] relation;
    static int[][] kevin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relation = new boolean[N + 1][N + 1];
        kevin = new int[N + 1][N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            relation[A][B] = true;
            relation[B][A] = true;
        } // 입력 끝

        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++)
                sum += getKevinBacon(i, j);

            if (min > sum) {
                min = sum;
                minIdx = i;
            }
        }

        System.out.println(minIdx);
    }

    private static int getKevinBacon(int A, int B) {
        if(kevin[A][B] > 0 || A == B)
            return kevin[A][B];

        int[] visited = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        visited[A] = 1;

        while (!q.isEmpty()) {
            int n = q.poll();

            if(n == B)
                break;

            for(int i = 1; i <= N; i++)
                if(relation[n][i] && visited[i] == 0) {
                    q.add(i);
                    visited[i] = visited[n] + 1;
                }
        }

        kevin[A][B] = visited[B] - 1;
        kevin[B][A] = visited[B] - 1;
        return kevin[A][B];
    }
}