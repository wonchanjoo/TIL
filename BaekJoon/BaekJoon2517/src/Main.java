import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static Player[] playerArr;
    static PriorityQueue<Player> players = new PriorityQueue<>();

    static int offset;
    static int[] tree;

    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        answer = new int[N];
        playerArr = new Player[N];

        // offset 구하기
        for(offset = 1; offset < N; offset *= 2);

        // 트리 생성
        tree = new int[offset * 2];

        for (int i = 0; i < N; i++) {
            int speed = Integer.parseInt(br.readLine());
            players.offer(new Player(i, speed));
        }

        for (int i = 0; i < N; i++) {
            Player p = players.poll();

            // 1. 자신의 순서면 tree에 1 업데이트
            update(p.idx, 1);

            // 2. 나보다 빠른 사람 중 속도가 빠른 사람을 찾는다.
            int count = sum(0, p.idx - 1);

            // 3. 등수이므로 +1 한 뒤, 배열에 저장한다
            answer[i] = count + 1;
        }

        // 등수 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(answer[i]).append('\n');
        System.out.println(sb);
    }

    private static void update(int idx, int value) {
        int i = idx + offset;
        tree[i] = value;

        while (i >= 1) {
            i /= 2; // 부모로 이동
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    private static int sum(int start, int end) {
        start += offset;
        end += offset;

        int sum = 0;
        while (start <= end) {
            if (start % 2 == 1)
                sum += tree[start++];
            if (end % 2 == 0)
                sum += tree[end--];

            start /= 2;
            end /= 2;
        }

        return sum;
    }

    static class Player implements Comparable<Player> {
        int idx, speed; // 현재 위치, 속도

        public Player(int idx, int speed) {
            this.idx = idx;
            this.speed = speed;
        }

        @Override
        public int compareTo(Player p) {
            if (this.speed > p.speed)           return -1;
            else if (this.speed == p.speed)     return 0; // speed가 같은 경우는 없지만
            else                                return 1;
        }
    }
}