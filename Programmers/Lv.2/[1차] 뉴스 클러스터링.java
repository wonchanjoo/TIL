import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        
        // 다중집합 생성
        for(int i = 0; i < str1.length() - 1; i++)
            if(Character.isLetter(str1.charAt(i)) && Character.isLetter(str1.charAt(i + 1))) 
                arr1.add(str1.substring(i, i + 2).toUpperCase());
        for(int i = 0; i < str2.length() - 1; i++)
            if(Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i + 1)))
                arr2.add(str2.substring(i, i + 2).toUpperCase());
        
        int unionSize = getUnion(arr1, arr2).size();
        int intersectionSize = getIntersection(arr1, arr2).size();
        if(unionSize == 0 && intersectionSize == 0) 
            return 65536;
        else
            return (int)((double)intersectionSize / unionSize * 65536);
    }
    
    // 교집합 반환
    ArrayList<String> getIntersection(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> intersection = new ArrayList<>();
        
        for(int i = 0; i < list1.size(); i++) {
            String temp = list1.get(i);
            
            if(!intersection.contains(temp) && list2.contains(temp)) {
                int min = Math.min(Collections.frequency(list1, temp), Collections.frequency(list2, temp));
                for(int j = 0; j < min; j++)
                    intersection.add(temp);
            }
        }
        
        return intersection;
    }
    
    // 합집합 반환
    ArrayList<String> getUnion(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> union = new ArrayList<>();
        
        for(int i = 0; i < list1.size(); i++) {
            String temp = list1.get(i);
            
            if(!union.contains(temp) && list2.contains(temp)) {
                int max = Math.max(Collections.frequency(list1, temp), Collections.frequency(list2, temp));
                for(int j = 0;  j < max; j++)
                    union.add(temp);
            } else if(!list2.contains(temp))
                union.add(temp);
        }
        
        for(int i = 0; i < list2.size(); i++)
            if(!list1.contains(list2.get(i)))
                union.add(list2.get(i));
        
        return union;
    }
}