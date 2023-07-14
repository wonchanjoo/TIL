import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] length = new long[N];
        long[] L = new long[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++) {
            length[i] = Integer.parseInt(st1.nextToken());
            L[i] = Integer.parseInt(st2.nextToken());
        }
        L[N - 1] = Integer.parseInt(st2.nextToken()); // 입력 끝

        long sum = 0;
        int i = 0, min = 0;
        while(i < N - 1) {
            if(L[i] < L[min]) {
                min = i;
            }
            sum += L[min] * length[i];
            i++;
        }

        System.out.println(sum);
    }
}