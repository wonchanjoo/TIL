import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;
    static String[] words;
    static Alpha[] alpha = new Alpha['Z' - 'A' + 1];
    static Map<Character, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = new Alpha((char) ('A' + i), 0);
        }

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            countAlpha(words[i]);
        }

        // 가중치 내림차 순으로 정렬
        Arrays.sort(alpha);

        // 알파벳 숫자 매칭
        matcingAlpha();

        // 문자열 -> 수 변환 후 계산
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            String s = "";
            for (int j = 0; j < words[i].length(); j++) {
                s += Integer.toString(hashMap.get(words[i].charAt(j)));
            }
            answer += Integer.parseInt(s);
        }

        System.out.println(answer);
    }

    private static void countAlpha(String s) {
        int tmp = s.length();
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'A'].weight += Math.pow(10, tmp);
            tmp--;
        }
    }

    private static void matcingAlpha() {
        int tmp = 9;

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i].weight == 0) {
                break;
            }

            hashMap.put(alpha[i].c, tmp--);
        }
    }

    static class Alpha implements Comparable<Alpha> {
        char c;
        int weight;

        public Alpha(char c, int weight) {
            this.c = c;
            this.weight = weight;
        }

        @Override
        public int compareTo(Alpha alpha) {
            return alpha.weight - this.weight;
        }
    }
}