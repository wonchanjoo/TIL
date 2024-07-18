import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L, C;
    static String[] alpha;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha = new String[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken();
        }

        Arrays.sort(alpha);

        for (int i = 0; i <= C - L; i++) {
            if (isVowel(alpha[i])) {
                dfs(i + 1, alpha[i], 1, 0);
            } else {
                dfs(i + 1, alpha[i], 0, 1);
            }

        }

        System.out.println(sb);
    }

    public static void dfs(int idx, String s, int vowel, int consonant) {
        if (s.length() == L && vowel >= 1 && consonant >= 2) {
            sb.append(s).append('\n');
            return;
        }

        for (int i = idx; i < C; i++) {
            if (isVowel(alpha[i])) {
                dfs(i + 1, s + alpha[i], vowel + 1, consonant);
            } else {
                dfs(i + 1, s + alpha[i], vowel, consonant + 1);
            }
        }
    }

    private static boolean isVowel(String s) {
        return s.compareTo("a") == 0 || s.compareTo("e") == 0 || s.compareTo("i") == 0 || s.compareTo("o") == 0 || s.compareTo("u") == 0;
    }
}