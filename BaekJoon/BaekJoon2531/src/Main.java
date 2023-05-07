import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N];
        int[] count = new int[d + 1];
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = start + k;
        for(int i = start; i < end; i++) { // 0 ~ k
            count[sushi[i]]++;
        }

        int max = getD(count, c);
        while(((start + 1) % N) != 0) {
            count[sushi[start]]--;
            count[sushi[end]]++;
            start = (start + 1) % N;
            end = (end + 1) % N;

            if(getD(count, c) > max) {
                max = getD(count, c);
            }
        }

        System.out.println(max);
    }

    // 초밥의 가짓수 반환
    private static int getD(int[] count, int coupon) {
        int c = 0;
        boolean containCoupon = false;

        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                c++;
                if(i == coupon) {
                    containCoupon = true;
                }
            }
        }

        if(containCoupon) {
            return c;
        } else {
            return c + 1;
        }
    }
}
