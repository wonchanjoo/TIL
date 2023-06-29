class Solution {
    public int solution(int[][] sizes) {
        int w = sizes[0][0];
        int h = sizes[0][1];
        
        for(int i = 1; i < sizes.length; i++) {
            int next_w = sizes[i][0];
            int next_h = sizes[i][1];
            
            // 바꾸지 않고 계산
            int w1 = Math.max(w, next_w);
            int h1 = Math.max(h, next_h);
            
            // 바꾸고 계산
            int w2 = Math.max(w, next_h);
            int h2 = Math.max(h, next_w);
            
            if(w1 * h1 > w2 * h2) {
                w = w2;
                h = h2;
            } else {
                w = w1;
                h = h1;
            }
        }
        return w * h;
    }
}