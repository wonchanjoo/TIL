import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    static ArrayList<Integer> answer = new ArrayList<>();
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        bfs(X);

        if(answer.size() == 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            Collections.sort(answer);
            for(int i = 0; i < answer.size(); i++) {
                sb.append(answer.get(i)).append('\n');
            }
            System.out.println(sb.toString());
        }
    }

    private static void bfs(int start) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            Integer[] n = queue.poll();
            for(int i = 0; i < graph[n[0]].size(); i++) {
                if(!visited[graph[n[0]].get(i)]) {
                    visited[graph[n[0]].get(i)] = true;
                    if(n[1] + 1 == K) {
                        answer.add(graph[n[0]].get(i));
                        continue;
                    }
                    queue.offer(new Integer[]{graph[n[0]].get(i), n[1] + 1});
                }
            }
        }
    }
}