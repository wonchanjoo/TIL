import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    static Set<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 30; i++) {
            hashSet.add(i);
        }

        for (int i = 1; i <= 28; i++) {
            hashSet.remove(Integer.parseInt(br.readLine()));
        }

        int[] answer = new int[2];
        Iterator<Integer> it = hashSet.iterator();
        answer[0] = it.next();
        answer[1] = it.next();
        Arrays.sort(answer);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}