import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, C, M;
    static int answer = 0;
    static List<Box>[] boxArr;
    static List<Box> truck = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        boxArr = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            boxArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            boxArr[src].add(new Box(dest, cnt));
        }

        for (int i = 1; i <= N; i++) {
            // i 마을에 박스를 내린다.
            while (!truck.isEmpty() && truck.get(0).dest == i) {
                Box box = truck.remove(0);
                answer += box.count;
            }

            // i 마을에서 박스를 싣는다.
            for (int j = 0; j < boxArr[i].size(); j++) {
                truck.add(boxArr[i].get(j));
            }

            manageTruck();
        }

        System.out.println(answer);
    }

    private static void manageTruck() {
        Collections.sort(truck);
        List<Box> newTruck = new ArrayList<>();

        int capacity = 0;
        for (int i = 0; i < truck.size(); i++) {
            Box box = truck.get(i);
            if (capacity + box.count > C) {
                newTruck.add(new Box(box.dest, C - capacity));
                truck = newTruck;
                return;
            }
            newTruck.add(box);
            capacity += box.count;
        }
    }

    static class Box implements Comparable<Box> {
        int dest, count;

        public Box(int dest, int count) {
            this.dest = dest;
            this.count = count;
        }

        @Override
        public int compareTo(Box box) {
            if (this.dest == box.dest) {
                return box.count - this.count;
            }
            return this.dest - box.dest;
        }
    }
}