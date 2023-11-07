import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int END = 1201;
    static int N;
    static Flower[] flowers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start_month = Integer.parseInt(st.nextToken());
            int start_day = Integer.parseInt(st.nextToken());
            int start = start_month * 100 + start_day;

            int end_month = Integer.parseInt(st.nextToken());
            int end_day = Integer.parseInt(st.nextToken());
            int end = end_month * 100 + end_day;

            flowers[i] = (new Flower(start, end));
        }

        Arrays.parallelSort(flowers);

        int end = 301;
        int count = 0;
        int idx = 0;
        while (end < END) {
            boolean found = false;
            int max = 0;

            for (int i = idx; i < N; i++) {
                if (flowers[i].start > end) {
                    break;
                }

                if (flowers[i].end >= max) {
                    idx = i + 1;
                    max = flowers[i].end;
                    found = true;
                }
            }

            if (!found) {
                break;
            }

            end = max;
            count++;
        }

        if (end < END) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }


    static class Flower implements Comparable<Flower> {
        int start, end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower flower) {
            if (this.start == flower.start) {
                return flower.end - this.end;
            }

            return this.start - flower.start;
        }
    }
}