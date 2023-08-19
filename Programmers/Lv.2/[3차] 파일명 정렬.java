import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        PriorityQueue<File> pq = new PriorityQueue<>();
        
        for (int i = 0; i < files.length; i++) {
            File file = new File(i, files[i]);
            pq.offer(file);
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll().fileStr;
        }
        
        return answer;
    }
    
    class File implements Comparable<File> {
        String fileStr, head;
        int idx, number;
        
        public File (int idx, String fileStr) {
            this.fileStr = fileStr;
            this.idx = idx;
            
            // head
            int i;
            for (i = 0; i < fileStr.length(); i++) {
                if ('0' <= fileStr.charAt(i) && fileStr.charAt(i) <= '9') {
                    break;
                }
            }
            this.head = fileStr.substring(0, i);
            
            // number
            int j;
            for (j = i; j < fileStr.length(); j++) {
                if (fileStr.charAt(j) < '0' || fileStr.charAt(j) > '9') {
                    break;
                }
            }
            this.number = Integer.parseInt(fileStr.substring(i, j));
        }
        
        @Override
        public int compareTo(File file) {
            if (this.head.compareToIgnoreCase(file.head) < 0) {
                return -1;
            } else if (this.head.compareToIgnoreCase(file.head) > 0) {
                return 1;
            }
            
            if (this.number == file.number) {
                    return this.idx - file.idx;
            }
            return this.number - file.number;   
        }
    }
}