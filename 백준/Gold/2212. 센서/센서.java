import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int[] sensors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        sensors = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        // 인접한 센서 간의 거리 계산
        int[] distance = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distance[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(distance);
        
        int answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += distance[i];
        }

        System.out.println(answer);
    }
}