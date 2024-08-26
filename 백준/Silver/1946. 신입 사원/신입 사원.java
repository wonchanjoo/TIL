import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, N;
    static Grade[] grades;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            grades = new Grade[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                grades[i] = new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(grades);

            int answer = 1;
            int min = grades[0].interview;
            for (int i = 1; i < N; i++) {
                if (grades[i].interview < min) {
                    answer++;
                    min = grades[i].interview;
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }

    static class Grade implements Comparable<Grade> {
        int document, interview;

        public Grade(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo(Grade grade) {
            return this.document - grade.document;
        }
    }
}