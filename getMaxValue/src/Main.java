import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] num = new int[10000000];
        int max;
        long start;
        long end;

        for(int i=1; i< num.length; i++)
            num[i] = (int) (Math.random() * 10000);

        start = System.currentTimeMillis();
        max = num[0];
        for(int i=1; i<num.length; i++)
            if(num[i] > max)
                max = num[i];
        end = System.currentTimeMillis();

        System.out.println("max = " + max);
        System.out.println("for -> " + (end - start));

        start = System.currentTimeMillis();
        max = Arrays.stream(num).max().getAsInt();
        end = System.currentTimeMillis();

        System.out.println("max = " + max);
        System.out.println("stream().max() -> " + (end - start)/1000);
    }
}
