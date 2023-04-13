import java.util.Stack;

public class Main {
    private static boolean[] visited = new boolean[9];
    private static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};

    public static void main(String[] args) {

    }

    private static void dfs_recursion(int node) {
        visited[node] = true; // 방문
        System.out.print(node + " -> "); // 방문 노드 출력
        // node의 인접한 노드 찾기
        for(int i : graph[node]) {
            if(!visited[i]) { // 방문하지 않은 노드면
                dfs_recursion(i); // dfs 수행
            }
        }
    }

    private static void dfs_stack(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.print(node + " -> ");

            for(int i : graph[node]) {
                if(!visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}
