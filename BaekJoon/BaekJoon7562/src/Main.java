import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int l;
    static int[][] board;
    static boolean[][] visited;
    static int[] current = new int[2];
    static int[] dest = new int[2];
    static int[] dirR = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dirC = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            visited = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            current[0] = Integer.parseInt(st.nextToken());
            current[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            dest[0] = Integer.parseInt(st.nextToken());
            dest[1] = Integer.parseInt(st.nextToken()); // 입력 끝

            Queue<Integer[]> q = new LinkedList<>();
            q.offer(new Integer[]{current[0], current[1]});
            board[current[0]][current[1]] = 1;

            while(!q.isEmpty()) {
                int r = q.peek()[0];
                int c = q.poll()[1];
                if(r == dest[0] && c == dest[1])
                    break;

                for(int i = 0; i < 8; i++) {
                    int newR = r + dirR[i];
                    int newC = c + dirC[i];

                    if(isRight(newR, newC) && board[newR][newC] == 0) {
                        board[newR][newC] = board[r][c] + 1;
                        q.offer(new Integer[]{newR, newC});
                    }
                }
            }

            sb.append(board[dest[0]][dest[1]] - 1).append('\n');
        }
        System.out.println(sb);
    }

    private static boolean isRight(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < l) && (c < l);
    }
}