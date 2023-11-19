import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] count = new int[id_list.length]; // i의 신고 횟수
        Set<String>[] reporter = new HashSet[id_list.length]; // i를 신고한 사람
        
        for (int i = 0; i < reporter.length; i++) {
            reporter[i] = new HashSet<>();    
        }
        
        // 각 유저에게 숫자 id 부여
        Map<String, Integer> id = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            id.put(id_list[i], i);
        }
        
        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            String user = st.nextToken();
            String reportedUser = st.nextToken();
            int reportedId = id.get(reportedUser);
            
            if (!reporter[reportedId].contains(user)) {
                count[reportedId]++;
                reporter[reportedId].add(user);
            }
        }
        
        // 신고 횟수가 k 이상인 유저 탐색
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= k) {
                Iterator<String> it = reporter[i].iterator();
                while (it.hasNext()) {
                    String user = it.next();
                    answer[id.get(user)]++;
                }
            }
        }
        
        return answer;
    }
}