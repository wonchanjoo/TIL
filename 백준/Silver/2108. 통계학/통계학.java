import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        sb.append(arithmeticMean()).append('\n');
        sb.append(median()).append('\n');
        sb.append(mode()).append('\n');
        sb.append(range());
        System.out.println(sb);
    }

    private static int arithmeticMean() {
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        return (int) Math.round(sum / N);
    }

    private static int median() {
        return arr[N / 2];
    }

    private static int mode() {
        Map<Integer, Integer> hashMap = new HashMap<>();

        // 빈도 계산
        for (int i : arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        int max = 0;
        for (Integer key: hashMap.keySet()) {
            max = Math.max(max, hashMap.get(key));
        }

        List<Integer> tmp = new ArrayList<>();
        for (Integer key : hashMap.keySet()) {
            if (hashMap.get(key) == max) {
                tmp.add(key);
            }
        }

        Collections.sort(tmp);
        if (tmp.size() == 1) {
            return tmp.get(0);
        } else {
            return tmp.get(1);
        }
    }

    private static int range() {
        return Math.abs(arr[N - 1] - arr[0]);
    }
}