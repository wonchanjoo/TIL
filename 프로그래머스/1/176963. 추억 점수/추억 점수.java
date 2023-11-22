class Solution {
    private String[] name;
    private int[] yearning;
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        this.name = name;
        this.yearning = yearning;
        
        int[] result = new int[photo.length];
        int i = 0;
        
        for(int j = 0; j < photo.length; j++) {
            int score = 0;
            for(int k = 0; k < photo[j].length; k++) {
                score += getYearning(photo[j][k]);
            }
            result[i++] = score;
        }
        
        return result;
    }
    
    private int getYearning(String n) {
        for(int i = 0; i < name.length; i++) {
            if(n.equals(name[i])) {
                return yearning[i];
            }
        }
        return 0;
    }
}