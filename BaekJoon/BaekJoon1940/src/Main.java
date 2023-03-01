import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for(int i = 0; i < N; i++)
            a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        int count = 0;
        int i = 0;
        int j = N - 1;
        while(i < j) {
            int sum = a[i] + a[j];
            if(sum < M)
                i++;
            else if(sum > M)
                j++;
            else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
    }
}
