import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean visited[][];
    static int maze[][];
    static int dirY[] = {-1, 1, 0, 0};
    static int dirX[] = {0, 0, -1, 1};
    static Queue<Node> queue = new LinkedList<>();

    static int now

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dir = new int[N][M];
        for(int r = 0; r < N; r++) {
            String s = br.readLine();
            for(int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c) - '0';
            }
        }

        countDir(0, 0);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(dir[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void countDir(int x, int y) {
        dir[x][y]++;
    }

    private static int getShortestPathCount() {
        return 0;
    }
}
