import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        card = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search());

    }

    private static int search() {
        int result = 0;

        // 3개의 카드를 고르기 때문에 첫 번째 카드는 N - 2 까지만 순회
        for(int i = 0; i < N - 2; i++) {
            // 두 번째 카드는 N - 1 까지만 순회
            for(int j = i + 1; j < N - 1; j++) {
                // 세 번째 카드는 N 까지만 순회
                for(int k = j + 1; k < N; k++) {
                    int temp = card[i] + card[j] + card[k];

                    if(M == temp) {
                        return temp;
                    }

                    if(temp < M && temp > result) {
                        result = temp;
                    }
                }
            }
        }

        return result;
    }
}