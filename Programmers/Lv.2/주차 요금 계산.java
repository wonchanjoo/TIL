import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        HashMap<String, String> parking = new HashMap<>(); // 입출차 관리
        HashMap<String, Integer> minute = new HashMap<>(); // 주차 시간
        HashMap<String, Integer> fee = new HashMap<>(); // 주차 요금
        
        for(int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            
            if(record[2].equals("IN")) { // 입차
                parking.put(record[1], record[0]);
            } else { // 출차
                String inTime = parking.remove(record[1]);
                // 주차 시간을 구해서 hashMap에 더해준다.
                int parkingMinute = getParkingMinute(inTime, record[0]);
                minute.put(record[1], minute.getOrDefault(record[1], 0) + parkingMinute);
            }
        }
        
        // 남아있는 차량들을 출차 시킨다.
        Iterator<Entry<String, String>> parking_it = parking.entrySet().iterator();
        while(parking_it.hasNext()) {
            Map.Entry<String, String> entry = parking_it.next();
            int parkingMinute = getParkingMinute(entry.getValue(), "23:59");
            minute.put(entry.getKey(), minute.getOrDefault(entry.getKey(), 0) + parkingMinute);
        }
        
        // 주차요금 계산
        Iterator<Entry<String, Integer>> minute_it = minute.entrySet().iterator();
        while(minute_it.hasNext()) {
            Map.Entry<String, Integer> entry = minute_it.next();
            
            // 기본 시간을 초과한 경우
            if(entry.getValue() > fees[0]) {
                int overTime = entry.getValue() - fees[0]; // 초과 시간
                int overFee = (int)Math.ceil((double)overTime / fees[2]) * fees[3]; // 초과 요금
                fee.put(entry.getKey(), overFee + fees[1]);
            }
            // 기본 시간을 초과하지 않은 경우
            else {
                fee.put(entry.getKey(), fees[1]);
            }
        }
    
        // 차량 번호가 작은 순서부터 
        int[] answer = new int[fee.size()];
        ArrayList<String> keyList = new ArrayList<>(fee.keySet());
        Collections.sort(keyList);
        for(int i = 0; i < answer.length; i++)
            answer[i] = fee.get(keyList.get(i));
        
        return answer;
    }
    
    private int getParkingMinute(String in, String out) {
        int inHour = Integer.parseInt(in.split(":")[0]) * 60;
        int inMinute = Integer.parseInt(in.split(":")[1]);
        int outHour = Integer.parseInt(out.split(":")[0]) * 60;
        int outMinute = Integer.parseInt(out.split(":")[1]);
        
        return (outHour + outMinute - inHour - inMinute);
    }
}