import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] nums = new int[N];
        for(int i=0; i<N; i++)
            nums[i] = sc.nextInt();

        int max = nums[0];
        for(int i=1; i<N; i++)
            if(nums[i] > max)
                max = nums[i];

        double sum = 0.0;
        for(int i=0; i<N; i++)
            sum += nums[i];

        double newAverage = sum / max * 100 / N;
        System.out.println(newAverage);
    }
}
