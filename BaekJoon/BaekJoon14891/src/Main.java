import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Wheel[] wheels = new Wheel[4];
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            int[] tmp = new int[8];
            String s = br.readLine();

            for (int j = 0; j < 8; j++) {
                tmp[j] = s.charAt(j) - '0';
            }

            wheels[i] = new Wheel(i, tmp);
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            wheels[num].move(direction);
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (wheels[i].top() == 1) {
                score += Math.pow(2, i);
            }
        }

        System.out.println(score);
    }

    static class Wheel {
        int[] pole;
        int idx, top;
        boolean moved = false;

        public Wheel(int idx, int[] pole) {
            this.idx = idx;
            this.pole = pole;
            this.top = 0;
        }

        private int top() {
            return pole[top];
        }

        private int left() {
            int tmp = top - 2;
            tmp = (tmp < 0) ? tmp + 8 : tmp;

            return pole[tmp];
        }

        private int right() {
            int tmp = top + 2;
            tmp = (tmp > 7) ? tmp - 8 : tmp;

            return pole[tmp];
        }

        private void move(int direction) {
            // 이미 내가 움직인 경우
            if (moved) {
                return;
            }

            moved = true;

            // 왼쪽에 맞닿은 힐이 있는 경우
            if (idx > 0 && wheels[idx - 1].right() != this.left()) {
                wheels[idx - 1].move(-direction);
            }
            // 오른쪽에 맞닿은 힐이 있는 경우
            if (idx < 3 && wheels[idx + 1].left() != this.right()) {
                wheels[idx + 1].move(-direction);
            }

            if (direction == 1) {
                top = (top - 1 < 0) ? 7 : (top - 1);
            } else {
                top = (top + 1 > 7) ? 0 : (top + 1);
            }

            moved = false;
        }
    }
}