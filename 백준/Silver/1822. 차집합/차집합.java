import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int nA, nB;
    static Set<Integer> A = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            int b = Integer.parseInt(st.nextToken());
            A.remove(b);
        }

        int[] answer = new int[A.size()];
        Iterator<Integer> it = A.iterator();
        int idx = 0;
        while (it.hasNext()) {
            answer[idx++] = it.next();
        }

        Arrays.sort(answer);

        sb.append(answer.length).append('\n');
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(' ');
        }

        System.out.println(sb);
    }
}