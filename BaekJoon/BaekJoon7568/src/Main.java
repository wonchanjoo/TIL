import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Person[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        people = new Person[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < N; i++) {
            int r = getRank(i);
            sb.append(r).append(' ');
        }

        System.out.println(sb.toString());
    }

    static int getRank(int i) {
        for(int j = 0; j < N; j++) {
            if(j != i) {
                if(people[i].height < people[j].height && people[i].weight < people[j].weight) {
                    people[i].rank++;
                }
            }
        }
        return people[i].rank;
    }

    static class Person {
        int weight;
        int height;
        int rank = 1;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
