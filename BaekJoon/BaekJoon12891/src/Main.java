import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] count = new int[4]; // 갯수를 검사할 때 사용. ACGT 순서
    static int[] min = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] DNA = br.readLine().toCharArray();
        int result = 0;

        // 부분 문자열에 포함되어야 할 A, C, G, T의 최소 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }

        // 처음 P개의 요소들을 모두 검사
        for (int i = 0; i < P; i++) {
            newChar(DNA[i]);
        }
        if(isValidPassword())
            result++;

        int newIndex = P, oldIndex = 0;
        while(newIndex < S) {
            newChar(DNA[newIndex++]);
            oldChar(DNA[oldIndex++]);
            if(isValidPassword())
                result++;
        }

        System.out.println(result);
    }

    // A, C, G, T 중 하나일 경우 해당 배열의 값을 +1
    private static void newChar(char c) {
        switch (c) {
            case 'A':
                count[0]++;
                break;
            case 'C':
                count[1]++;
                break;
            case 'G':
                count[2]++;
                break;
            case 'T':
                count[3]++;
                break;
        }
    }

    // A, C, G, T 중 하나일 경우 해당 배열의 값을 -1
    private static void oldChar(char c) {
        switch (c) {
            case 'A':
                count[0]--;
                break;
            case 'C':
                count[1]--;
                break;
            case 'G':
                count[2]--;
                break;
            case 'T':
                count[3]--;
                break;
        }
    }

    private static boolean isValidPassword() {
        for (int i = 0; i < 4; i++) {
            if(count[i] < min[i])
                return false;
        }
        return true;
    }

}
