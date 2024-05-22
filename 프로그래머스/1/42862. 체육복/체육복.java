class Solution {
    
    int[] arr;
    
    public int solution(int n, int[] lost, int[] reserve) {
        arr = new int[n + 1];
        
        for (int i : lost) {
            arr[i]--;
        }
        for (int i : reserve) {
            arr[i]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 1 && rangeIn(i - 1) && arr[i - 1] == -1) {
                arr[i] = arr[i - 1] = 0;
            } else if (arr[i] == 1 && rangeIn(i + 1) && arr[i + 1] == -1) {
                arr[i + 1] = arr[i + 1] = 0;
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] >= 0) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean rangeIn(int i) {
        return (i > 0) && (i < arr.length);
    }
}