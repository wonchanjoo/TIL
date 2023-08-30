import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        PriorityQueue<Music> pq = new PriorityQueue<>();
        String melody = toNewMelody(m);
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            String newMelody = toNewMelody(info[3]); // 새로운 멜로디로 변환
            
            // 재생된 시간(분) 계산
            String[] s = info[0].split(":");
            String[] e = info[1].split(":");
            
            int startHour = Integer.parseInt(s[0]) * 60;
            int startMinute = Integer.parseInt(s[1]);
            int endHour = Integer.parseInt(e[0]) * 60;
            int endMinute = Integer.parseInt(e[1]);
            
            int time = (endHour + endMinute) - (startHour + startMinute);
            
            // 조건에 맞는 음악 찾기
            int rep = time / newMelody.length(); // 반복 횟수
            int rest = time % newMelody.length(); // 반복하고 남은 멜로디
            String realMusic = newMelody.repeat(rep) + newMelody.substring(0, rest);
                
            if (realMusic.contains(melody)) {
                pq.offer(new Music(i, info[2], time));
            }
        }
        
        if (pq.isEmpty()) {
            return "(None)";
        } else {
            return pq.peek().name;
        }
    }
    
    // #을 없애고 새로운 멜로디를 반환해주는 함수
    private String toNewMelody(String s) {
        s = s.replaceAll("C#", "H");
        s = s.replaceAll("D#", "I");
        s = s.replaceAll("F#", "J");
        s = s.replaceAll("G#", "K");
        s = s.replaceAll("A#", "L");
    
        return s;
    }
    
    class Music implements Comparable<Music> {
        int idx, time;
        String name;
        
        public Music(int idx, String name, int time) {
            this.idx = idx;
            this.name = name;
            this.time = time;
        }
        
        @Override
        public int compareTo(Music music) {
            if (this.time == music.time) {
                return this.idx - music.idx;
            }
            return music.time - this.time;
        }
    }
}