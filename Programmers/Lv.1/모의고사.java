class Solution {
    public int[] solution(int[] answers) {
        int[][] supo = {{1, 2, 3, 4, 5},
                       {2, 1, 2, 3, 2, 4, 2, 5},
                       {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] index = new int[3];
        int[] count = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < 3; j++) {
                if(supo[j][index[j]] == answers[i]) {
                    count[j]++;
                }
                index[j] = (index[j] + 1) % supo[j].length;
            }
        }
        
        // 모두 동점자인 경우
        if(count[0] == count[1] && count[1] == count[2]) {
            int[] result = {1, 2, 3};
            return result;
        }
        
        
        int max = 0;
        for(int i = 1; i < 3; i++) {
            if(count[max] < count[i]) {
                max = i;
            } else if(count[max] == count[i]) { // 동점자가 2명인 경우
                int[] result = {(max + 1), (i + 1)};
                return result;
            }
        }
        int[] result = {(max + 1)};
        return result;
    }
}