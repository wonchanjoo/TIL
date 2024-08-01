class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        if (arr1.length != arr2.length) {
            answer = Integer.compare(arr1.length, arr2.length);
        } else {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < arr1.length; i++) {
                sum1 += arr1[i];
                sum2 += arr2[i];
            }
            answer = Integer.compare(sum1, sum2);
        }
        
        return answer;
    }
}