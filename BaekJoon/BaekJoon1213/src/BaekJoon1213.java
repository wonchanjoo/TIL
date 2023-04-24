import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class BaekJoon1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            int count = getCharCount(str, str.charAt(i));
            hashMap.put(str.charAt(i), count);
        }

        Character[] keys = hashMap.keySet().toArray(new Character[0]);
        Arrays.sort(keys);

        int i = 0;
        Character middle = '\0';
        while(i < keys.length) {
            if(hashMap.get(keys[i]) % 2 == 0) { // 짝수개 만큼 있으면
                stack.push(keys[i]);
                sb.append(keys[i++]);
            } else {
                if(hashMap.get(keys[i]) == 1) {

                } else {
                    
                }
            }
        }
    }


    private static int getCharCount(String s, Character c) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
