import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // 그래프를 2차원 배열로 표현, README 참고
        int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};

        // 방문 처리를 위한 boolean 배열 선언
        boolean[] visited = new boolean[9]; // 노드가 9까지니까 인덱스고 9까지 필요!
        System.out.println(bfs(1, graph, visited));
    }

    private static String bfs(int start, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<Integer>();

        // 큐에 BFS를 시작 노드 번호를 넣어준다
        queue.offer(start);
        // 시작 노드 방문 처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            int nodeIndex = queue.poll();
            sb.append(nodeIndex).append(" -> ");

            // 큐에서 꺼낸 노드와 연결된 노드들 체크
            for(int i = 0; i < graph[nodeIndex].length; i++) {
                int temp = graph[nodeIndex][i];
                if (!visited[temp]) { // 아직 방문하지 않은 경우
                    visited[temp] = true; // 방문
                    queue.offer(temp);
                }
            }
        }

        return sb.toString();
    }
}
