class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            String skill_tree = skill_trees[i];
            int skillIdx = 0;
            boolean pass = true;
            
            for (int j = 0; j < skill_tree.length(); j++) {
                char c = skill_tree.charAt(j);
                
                if (skill.indexOf(c) == -1) {
                    continue;
                }
                
                if (c != skill.charAt(skillIdx)) {
                    pass = false;
                    break;
                }
                
                skillIdx++;
            }
            
            if (pass) {
                answer++;
            }
        }
        
        return answer;
    }
}