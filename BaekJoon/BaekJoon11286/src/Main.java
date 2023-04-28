import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);
                if(a == b) {
                    if(o1 < o2) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return a - b;
                }
            }
        });

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0) {
                heap.offer(x);
            } else {
                if(heap.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(heap.poll()).append('\n');
                }
            }
        }

        System.out.println(sb.toString());
    }
}
