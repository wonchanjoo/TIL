import java.util.Arrays;
import java.util.Scanner;

/*
세준이는 기말고사를 망쳤다. 그래서 점수를 조작해 집에 가져가기로 결심했다. 일단 세준이는 자기 점수 중 최댓값을 골랐다.
그런 다음 최댓값을 M이라 할 때 모든 점수를 점수/M*100으로 고쳤다. 예를 들어 세준이의 최고점이 70점, 수학 점수가 50점이라면
수학 점수는 50*70/100이므로 71.43점이다. 세준이의 성적을 이 방법으로 계산했을 때 새로운 평균을 구하는 프로그램을 작성하시오
입력: 1번째 줄에 시험을 본 과목의 개수 N이 주어진다. 해당 값은 1,000보다 작거나 같다.
     2번째 줄에 세준이의 현재 성적이 주어진다. 해당 값은 100보다 작거나 같은, 음이 아닌 정수이고, 적어도 1개의 값은 0보다 크다.
출력: 1번재 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대 오차 또는 상대 오차가 10^-2이하이면 답이다.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] nums = new int[N];
        for(int i=0; i<N; i++)
            nums[i] = sc.nextInt();

        double max = Arrays.stream(nums).asDoubleStream().max().getAsDouble();

        double sum = 0.0;
        for(int i=0; i<N; i++) {
            double d = nums[i] / max * 100.0;
            sum += d;
        }

        System.out.println(sum / N);
    }
}
