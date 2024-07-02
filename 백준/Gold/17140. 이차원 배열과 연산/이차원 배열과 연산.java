import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int r, c, k, N, M;
    static int[][] arr = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = M = 3;

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = -1;
        for (int i = 0; i <= 100; i++) {
            if (arr[r][c] == k) {
                answer = i;
                break;
            }

            if (N >= M) {
                R();
            } else {
                C();
            }
        }

        System.out.println(answer);
    }

    private static void R() {
        int maxCol = 0;

        for (int r = 1; r <= N; r++) {
            // 각 수의 등장 횟수를 계산한다.
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int c = 1; c <= M; c++) {
                if (arr[r][c] != 0) {
                    hashMap.put(arr[r][c], hashMap.getOrDefault(arr[r][c], 0) + 1);
                }
            }

            // 행 정렬을 수행한다.
            List<Node> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));
            }
            Collections.sort(list);

            // arr 배열에 복사한다.
            int idx = 1;
            for (Node node : list) {
                if (idx > 100) {
                    break;
                }
                arr[r][idx++] = node.num;
                arr[r][idx++] = node.cnt;
            }

            maxCol = Math.max(maxCol, idx - 1);

            // 나머지는 0으로 채워준다.
            while (idx <= 100) {
                arr[r][idx++] = 0;
            }
        }

        // 열 크기를 변경한다.
        M = maxCol;
    }

    private static void C() {
        int maxRow = 0;

        for (int c = 1; c <= M; c++) {
            // 각 수의 등장 횟수를 계산한다.
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int r = 1; r <= N; r++) {
                if (arr[r][c] != 0) {
                    hashMap.put(arr[r][c], hashMap.getOrDefault(arr[r][c], 0) + 1);
                }
            }

            // 열 정렬을 수행한다.
            List<Node> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));
            }
            Collections.sort(list);

            // arr 배열에 복사한다.
            int idx = 1;
            for (Node node : list) {
                if (idx > 100) {
                    break;
                }
                arr[idx++][c] = node.num;
                arr[idx++][c] = node.cnt;
            }

            maxRow = Math.max(maxRow, idx - 1);

            // 나머지는 0으로 채워준다.
            while (idx <= 100) {
                arr[idx++][c] = 0;
            }
        }

        // 행 크기를 변경한다.
        N = maxRow;
    }

    static class Node implements Comparable<Node> {
        int num, cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node n) {
            if (this.cnt == n.cnt) {
                return this.num - n.num;
            }
            return this.cnt - n.cnt;
        }
    }
}