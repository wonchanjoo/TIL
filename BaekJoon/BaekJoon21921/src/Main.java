import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] visitor = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i < X; i++) {
            sum += visitor[i];
        }
        int max = sum;
        int maxCount = 0;

        int start = 0;
        int end = start + X;
        while(end < N) {
            sum -= visitor[start++];
            sum += visitor[end++];
            if(max < sum) {
                max = sum;
                maxCount = 0;
            } else if(max == sum) {
                maxCount++;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(maxCount + 1);
        }
    }
}
