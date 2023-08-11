class Solution {
    
    int answer = 0;
    int[][] dungeons;
    boolean[] visited;
    
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        dfs(k, 0);
        
        return answer;
    }
    
    private void dfs(int remainK, int count) {    
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= remainK) {
                visited[i] = true;
                dfs(remainK - dungeons[i][1], count + 1); // 새로운 던전 탐험
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer, count);
    }
}