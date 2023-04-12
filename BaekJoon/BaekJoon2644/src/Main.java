import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n + 1][n + 1]; // 인덱스 0을 사용하지 않기 위헤
        boolean[] visited = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        int chon = 0;
        // 시작 노드 처리
        queue.offer(a);
        visited[a] = true;
        int lastNode = a;

        int temp = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int i = 0; i <= n; i++) {
                if(graph[node][i] == 1 && !visited[i]) { // 간선이 존재하고, 아직 방문하지 않았으면
                    if(i == b) { // b를 찾은 경우
                        lastNode = b;
                        break; // for문 끝
                    }
                    queue.offer(i); // 자식 노드 큐에 삽입
                    visited[i] = true; // 자식 노드 방문 표시
                    temp = i; // 여태까지 큐에 삽입된 노드 번호들
                }
            }
            if(lastNode == b) {
                chon++;
                break;
            }
            if(lastNode == node) { // 내가 라인 끝 노드면
                chon++; // 촌수 증가
                lastNode = temp; // lastNode 업데이트
            }
        }
        if(temp == lastNode) {
            System.out.println(-1);
        } else {
            System.out.println(chon);
        }
    }
}
