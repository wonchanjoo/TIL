import java.util.PriorityQueue;
import java.util.Comparator;

class Stage {
    int num;
    int challenger = 0; // 도전자
    int failure = 0; // 실패자
    double failureRate = 0.0; // 실패율

    public Stage(int num) {
        this.num = num;
    }
    
    double getFailureRate() {
        return (double)failure / challenger;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Stage[] stage = new Stage[N + 1];
        PriorityQueue<Stage> pq = new PriorityQueue<>(new Comparator<Stage>() {
            @Override
            public int compare(Stage s1, Stage s2) {
                double temp = s1.getFailureRate() - s2.getFailureRate();
                if(temp < 0) { // s2 > s1
                    return 1;
                } else if(temp > 0) { // s1 > s2
                    return -1;
                } else {
                    if(s1.num > s2.num) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        
        // Stage instance 생성
        for(int i = 0; i < stage.length; i++) {
            stage[i] = new Stage(i);
        }
        
        for(int i = 0; i < stages.length; i++) {
            int j;
            // i번째 사람은 1 ~ stage[j]까지 도전함
            for(j = 1; j <= stages[i] && j <= N; j++) {
                stage[j].challenger++;
            }
            if(stages[i] <= N) {
                stage[j - 1].failure++;
            }
        }
        
        // Priority Queue에 삽입
        for(int i = 1; i < stage.length; i++) {
            pq.offer(stage[i]);
        }
       
        // 실패율 내림차 순으로 삭제
        for(int i = 0; i < N; i++) {
            answer[i] = pq.poll().num;
        }
        
        return answer;
    }
}