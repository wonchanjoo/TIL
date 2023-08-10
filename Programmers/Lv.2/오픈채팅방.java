import java.util.*;

class Solution {
    
    ArrayList<Message> messages = new ArrayList<>();
    HashMap<String, String> users = new HashMap<>();
    
    public String[] solution(String[] record) {
        String msg;
        
        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            String uid = str[1];
            
            switch (str[0]) {
                case "Enter":    
                    messages.add(new Message(uid, "님이 들어왔습니다."));
                    users.put(uid, str[2]);
                    break;
                case "Leave":
                    messages.add(new Message(uid, "님이 나갔습니다."));
                    break;
                case "Change":
                    users.put(uid, str[2]);
                    break;
            }
        }
        
        String[] answer = new String[messages.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = messages.get(i).getMessage();
        }
        
        return answer;
    }
    
    class Message {
        String uid, msg;
        
        public Message(String uid, String msg) {
            this.uid = uid;
            this.msg = msg;
        }
        
        public String getMessage() {
            return users.get(uid) + msg;
        }
    }
}