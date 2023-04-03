import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] heap; // 최소 히프 트리
    private static int size = 0;

    private static void insert(int n) {
        int i = ++size;
        int abs = Math.abs(n);

        while((i != 1) && (abs < heap[i / 2])) { // 절댓값으로 비교하고
            heap[i] = heap[i / 2];
            i /= 2;
        }
        heap[i] = n; // 삽입하는건 절댓값 적용하지 않은 수
    }

    private static int delete() {
        if(size == 0)
            return 0;

        int parent, child;
        int root, temp;

        root = heap[1];
        for(int i = 2; i <= size; i++) {
            if(Math.abs(root) == Math.abs(heap[i]) && root > heap[i]) {
                int t = root;
                root = heap[i];
                heap[1] = heap[i];
                heap[i] = t;
            }
            if(Math.abs(root) < Math.abs(heap[i]))
                break;
        }

        temp = heap[size--]; // 말단
        parent = 1;
        child = 2;

        while(child <= size) {
            if((child < size) && Math.abs(heap[child]) > Math.abs(heap[child + 1])) // 오른쪽이 더 작으면
                child++;
            if(Math.abs(temp) <= Math.abs(heap[child])) // 자식보다 작아지면 그 자리가 제자리
                break;
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        heap = new int[N + 1]; // index 0은 사용하지 않는다.

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                sb.append(delete()).append('\n');
            } else {
                insert(x);
            }
        }

        System.out.println(sb.toString());
    }
}
