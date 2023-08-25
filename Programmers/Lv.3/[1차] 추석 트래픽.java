import java.util.*;

class Solution {
    
    Request[] requests;
    
    public int solution(String[] lines) {
        int answer = 1;
        requests = new Request[lines.length];
        
        // 로그문자열 Request 객체로 변환
        for (int i = 0; i < lines.length; i++) {
            StringTokenizer st = new StringTokenizer(lines[i]);
            String date = st.nextToken();
            String S = st.nextToken();
            String T = st.nextToken();
            
            Request request = getRequest(S, T);
            requests[i] = request;
        }
        
        // 로그의 시작과 끝에서 처리되고 있는 요청의 개수
        for (int i = 0; i < requests.length; i++) {
            int count = 0;
            long end = requests[i].end;
            
            for (int j = 0; j < requests.length; j++) {
                if (requests[j].start < end + 1000 && requests[j].end >= end) {
                    count++;
                }
            }
            
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
    
    private Request getRequest(String S, String T) {
        long t = (long) (Double.parseDouble(T.substring(0, T.length() - 1)) * 1000);
        
        // 응답완료시간 분리
        StringTokenizer st = new StringTokenizer(S, ":");
        long hour = Integer.parseInt(st.nextToken()) * 1000;
        long minute = Integer.parseInt(st.nextToken()) * 1000;
        long second = (long) (Double.parseDouble(st.nextToken()) * 1000);
        
        second += minute * 60;
        second += hour * 3600;

        return new Request(second - t + 1, second);
    }
    
    class Request {
        long start, end;
            
        public Request(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}