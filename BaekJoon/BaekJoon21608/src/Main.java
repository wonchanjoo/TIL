import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    static int N;
    static int[] order;                             // 학생의 순서
    static HashMap<Integer, Set<Integer>> students; // 학생의 정보
    static int[][] classroom;                       // 교실의 자리 배치도
    static int[][] satisfaction;                    // 각 자리별 만족도

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        order = new int[N * N];
        students = new HashMap<>();
        classroom = new int[N][N];
        satisfaction = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 학생의 번호
            order[i] = n;

            Set<Integer> likeFriends = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                likeFriends.add(Integer.parseInt(st.nextToken()));
            }

            students.put(n, likeFriends);
        } // 입력 끝

        // 1. 자리 배정
        for (int i = 0; i < N * N; i++) {
            PriorityQueue<Seat> pq = new PriorityQueue<>();
            int number = order[i];

            // 비어있는 자리가 있으면 해당 자리의 정보를 우선 순위 큐에 넣는다.
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (classroom[r][c] == 0) {
                        pq.offer(seatInfo(r, c, students.get(number)));
                    }
                }
            }

            Seat seat = pq.poll(); // 배정된 자리
            classroom[seat.r][seat.c] = number;
            satisfaction[seat.r][seat.c] = seat.like;

            // 나와 인접한 자리에 앉은 학생 중, 나를 좋아하는 학생이 있으면 만족도를 1 올려준다.
            for (int j = 0; j < 4; j++) {
                int r = seat.r + dirR[j];
                int c = seat.c + dirC[j];

                if (rangeIn(r, c) && classroom[r][c] > 0) {
                    int tmp = classroom[r][c];

                    if (students.get(tmp).contains(number)) {
                        satisfaction[r][c]++;
                    }
                }
            }
        }

        // 2. 만족도 계산
        int sum = getSatisfaction();

        System.out.println(sum);
    }

    private static Seat seatInfo(int r, int c, Set likeFriends) {
        int empty = 0;
        int like = 0;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dirR[i];
            int nextC = c + dirC[i];

            if (rangeIn(nextR, nextC)) {
                if (classroom[nextR][nextC] == 0) {
                    empty++;
                } else if (likeFriends.contains(classroom[nextR][nextC])) {
                    like++;
                }
            }
        }

        return new Seat(r, c, empty, like);
    }

    private static int getSatisfaction() {
        int sum = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                switch (satisfaction[r][c]) {
                    case 1:
                        sum += 1;
                        break;
                    case 2:
                        sum += 10;
                        break;
                    case 3:
                        sum += 100;
                        break;
                    case 4:
                        sum += 1000;
                        break;
                }
            }
        }

        return sum;
    }

    private static boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < N) && (c < N);
    }

    static class Seat implements Comparable<Seat> {
        int r, c, empty, like;

        public Seat(int r, int c, int empty, int like) {
            this.r = r;
            this.c = c;
            this.empty = empty;
            this.like = like;
        }

        @Override
        public int compareTo(Seat seat) {
            if (this.like == seat.like) {

                if (this.empty == seat.empty) {

                    if (this.r == seat.r) {
                        return this.c - seat.c;
                    }

                    return this.r - seat.r;
                }

                return seat.empty - this.empty;
            }

            return seat.like - this.like;
        }
    }
}