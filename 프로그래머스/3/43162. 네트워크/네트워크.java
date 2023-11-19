class Solution {
    int[][] computers;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.visited = new boolean[computers.length];
        
        int result = 0;
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                dfs(i);
                result++;
            }
        }
        
        return result;
    }
    
    private void dfs(int node) {
        visited[node] = true;
        
        for(int i = 0; i < computers[node].length; i++) {
            if(!visited[i] && computers[node][i] == 1) {
                dfs(i);
            }
        }
    }
}