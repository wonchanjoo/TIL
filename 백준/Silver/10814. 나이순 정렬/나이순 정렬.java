import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static Person[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        people = new Person[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(i, Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(people);

        for (int i = 0; i < N; i++) {
            sb.append(people[i].age).append(' ').append(people[i].name).append('\n');
        }
        System.out.print(sb);
    }

    static class Person implements Comparable<Person> {
        int idx, age;
        String name;

        public Person(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person person) {
            if (this.age == person.age) {
                return this.idx - person.idx;
            }
            return this.age - person.age;
        }
    }
}