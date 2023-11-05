import java.util.*;

class Solution {

    public int solution(String begin, String target, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (!wordSet.contains(target)) {
            return 0; // 변환할 수 없는 경우
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return level;
                }

                char[] chars = current.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                    chars[j] = originalChar; // 원래 문자로 복원
                }
            }
            level++;
        }

        return 0; // 변환할 수 없는 경우
    }
}