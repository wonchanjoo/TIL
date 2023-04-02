import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++) // n까지의 카드 큐에 추가
            queue.add(i);

        while(n-- > 1) {
            queue.poll();
            int temp = queue.poll();
            queue.add(temp);
        }
        System.out.println(queue.peek());
    }
}