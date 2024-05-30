import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, L;
    static Puddle[] puddles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        puddles = new Puddle[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            puddles[i] = new Puddle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(puddles);

        int start = -1;
        int end = -1;
        int count = 0;
        int length = 0;
        for (int i = 0; i < N; i++) {
            if (end < puddles[i].start) {
                length = puddles[i].end - puddles[i].start;
                start = puddles[i].start;
            } else if (end < puddles[i].end) {
                length = puddles[i].end - end;
                start = end;
            } else {
                continue;
            }

            int newCount = (length % L == 0) ? (length / L) : (length / L + 1);
            count += newCount;
            end = start + newCount * L;
        }

        System.out.println(count);
    }

    static class Puddle implements Comparable<Puddle> {
        int start, end;

        public Puddle(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Puddle p) {
            if (this.start == p.start) {
                return this.end - p.end;
            }
            return this.start - p.start;
        }
    }
}