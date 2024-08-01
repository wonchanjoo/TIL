import java.util.*;

class Solution {
    
    List<String> number = new ArrayList<>();
    
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        initNumberList();
        
        for (int i = 0; i < s.length(); i++) {
            if (!isAlpha(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                int j = i + 1;
                
                while (isAlpha(s.charAt(j))) {
                    String word = s.substring(i, j + 1);
                    if (number.contains(word)) {
                        sb.append(getNumber(word));
                        break;
                    }
                    j++;
                }
                
                i = j;
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
    
    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z');
    }
    
    private void initNumberList() {
        number.add("zero");
        number.add("one");
        number.add("two");
        number.add("three");
        number.add("four");
        number.add("five");
        number.add("six");
        number.add("seven");
        number.add("eight");
        number.add("nine");
    }
    
    private int getNumber(String s) {
        for (int i = 0; i < 10; i++) {
            if (number.get(i).equals(s)) {
                return i;
            }
        }
        
        return -1;
    }
}