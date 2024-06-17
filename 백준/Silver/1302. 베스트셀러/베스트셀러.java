import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static Map<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            hashMap.put(book, hashMap.getOrDefault(book, 0) + 1);
        }

        PriorityQueue<Book> pq = new PriorityQueue<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.count == o2.count) {
                    return o1.name.compareTo(o2.name);
                }
                return o2.count - o1.count;
            }
        });

        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            pq.offer(new Book(key, hashMap.get(key)));
        }

        System.out.println(pq.poll().name);
    }

    static class Book {
        String name;
        int count;

        public Book(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}