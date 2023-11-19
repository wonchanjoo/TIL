import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    ArrayList<Integer> queue = new ArrayList<>();
    
    public int[] solution(String[] operations) {
        for(int i = 0; i < operations.length; i++) {
            String op = operations[i];
            if(op.equals("D 1")) {
                if(queue.size() > 0) {
                    queue.remove(getMaxIndex());
                }
            } else if(op.equals("D -1")) {
                if(queue.size() > 0) {
                    queue.remove(getMinIndex());
                }
                
            } else {
                StringTokenizer st = new StringTokenizer(op);
                st.nextToken();
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }
        
        if(queue.size() == 0) {
            return new int[]{0, 0};
        } else {
            return new int[]{queue.get(getMaxIndex()), queue.get(getMinIndex())};
        }
    }
    
    private int getMinIndex() {
        int min = 0;
        for(int i = 1; i < queue.size(); i++) {
            if(queue.get(i) < queue.get(min)) {
                min = i;
            }
        }
        
        return min;
    }
    
    private int getMaxIndex() {
        int max = 0;
        for(int i = 1; i < queue.size(); i++) {
            if(queue.get(i) > queue.get(max)) {
                max = i;
            }
        }
        
        return max;
    }
}