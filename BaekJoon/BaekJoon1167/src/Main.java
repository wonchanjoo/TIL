import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V;
    static List[] adjList;
    static boolean[] visited;
    static Edge max = new Edge(0, 0);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());

        adjList = new List[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            while(true) {
                int v = Integer.parseInt(st.nextToken());
                if(v == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());

                adjList[n].add(new Edge(v, w));
            }
        }

        visited[1] = true;
        dfs(1, 0);

        visited[1] = false;
        visited[max.target] = true;
        dfs(max.target, 0);

        System.out.println(max.cost);
    }

    private static void dfs(int n, int sum) {
        if (max.cost < sum) {
            max.cost = sum;
            max.target = n;
        }

        for (int i = 0; i < adjList[n].size(); i++) {
            Edge edge = (Edge) adjList[n].get(i);

            if (!visited[edge.target]) {
                visited[edge.target] = true;
                dfs(edge.target, sum + edge.cost);
                visited[edge.target] = false;
            }
        }
    }

    static class Edge {
        int target, cost;

        public Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
}