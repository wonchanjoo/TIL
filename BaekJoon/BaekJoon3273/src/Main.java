import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(a);

        int i = 0, j = n - 1, count = 0;
        while(i < j) {
            int sum = a[i] + a[j];
            if(sum < x) {
                i++;
            } else if (sum == x) {
                count++;
                i++;
                j--;
            } else {
                j--;
            }
        }

        System.out.println(count);
    }
}
