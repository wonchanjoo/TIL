import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R;
    static int[][] people;
    static boolean[][] visited;
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        people = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++)
                people[r][c] = Integer.parseInt(st.nextToken());
        } // 입력 끝

        int count = 0;
        while (true) {
            visited = new boolean[N][N];
            int max = 1;

            for (int r = 0; r < N; r++)
                for (int c = 0; c < N; c++)
                    if(!visited[r][c]) {
                        int temp = move(r, c);
                        if(temp > max)
                            max = temp;
                    }

            if(max == 1)
                break;

            count++;
        }

        System.out.println(count);
    }

    private static int move(int r, int c) {
        ArrayList<Point> q = new ArrayList<>();
        int idx = 0;
        int sum = 0;

        q.add(new Point(r, c));
        visited[r][c] = true;
        sum += people[r][c];

        while (idx < q.size()) {
            Point p = q.get(idx++);

            for(int i = 0; i < 4; i++) {
                Point next = new Point(p.r + dirR[i], p.c + dirC[i]);

                if(isNext(p, next)) {
                    visited[next.r][next.c] = true;
                    q.add(next);
                    sum += people[next.r][next.c];
                }
            }
        }

        for (int i = 0; i < q.size(); i++) {
            Point p = q.get(i);
            people[p.r][p.c] = sum / q.size();
        }

        return q.size();
    }

    private static boolean isNext(Point present, Point next) {
        if(rangeIn(next.r, next.c)) {
            int temp = Math.abs(people[present.r][present.c] - people[next.r][next.c]);
            return !visited[next.r][next.c] && temp >= L && temp <= R;
        }
        return false;
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < N);
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}