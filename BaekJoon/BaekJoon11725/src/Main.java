import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] tree;
    public static boolean[] visited;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        bfs();
        for(int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int p = q.poll(); // 부모

            for(int i = 0; i < tree[p].size(); i++) {
                int c = tree[p].get(i);
                if(!visited[c]) {
                    parent[c] = p;
                    visited[c] = true;
                    q.offer(c);
                }
            }
        }
    }
}
