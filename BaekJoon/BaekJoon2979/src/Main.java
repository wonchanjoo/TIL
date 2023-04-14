import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] fare = new int[101];
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for(int j = s; j < e; j++) {
                fare[j]++;
            }
        }

        int sum = 0;
        for(int i = 1; i <= 100; i++) {
            if(fare[i] == 1)
                sum += A;
            else if(fare[i] == 2)
                sum = sum + B * 2;
            else if(fare[i] == 3)
                sum = sum +  C * 3;
        }
        System.out.println(sum);
    }
}
