import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static Meeting[] meetings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        Arrays.sort(meetings);

        int current = 0;
        int answer = 1;
        for (int i = 1; i < N; i++) {
            if (meetings[i].start >= meetings[current].end) {
                answer++;
                current = i;
            }
        }

        System.out.println(answer);
    }

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting meeting) {
            if (this.end == meeting.end) {
                return this.start - meeting.start;
            }
            return this.end - meeting.end;
        }
    }
}