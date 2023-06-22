### ✔️ 접근 방법

- 체스판을 만들기 위해서는 **한 칸이 상하좌우의 색과 다르면** 된다.
- 경우의 수 = (가로 칸 개수 - 7) x (세로 칸 개수 - 7) x 2(첫번째 칸이 하얀색인 경우와 검은색인 경우)

```java
int N_row = N - 7;
int M_col = M - 7;

for(int i = 0; i < N_row; i++) {
  for(int j = 0; j < M_col; j++) {
    find(i, j);
  }
}


public static void find(int x, int y) {
  int end_x = x + 8;
  int ent_y = y + 8;
  int count = 0;
  
  boolean TF = arr[x][y]; // 첫 번째 칸의 색
  
  for(int i = x; i < end_x; i++) {
    for(int j = y; j < end_y; j++) {
      // 올바른 색이 아닐 경우 count 1 증가
      if(arr[i][j] != TF) {
        count++;
      }
      
      // 다음 칸 색상으로 TF를 변경해준다.
      TF = (!TF);
    } // for문 끝
    
    TF = !TF;
  } // for문 끝
  
  /*
   * 첫 번째 칸을 기준으로 할 떄의 색칠 할 개수(count)와
   * 첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
   * 색칠 할 개수(64-count) 중 최솟값을 count에 저장
   */
  count = Math.min(count, 64 - count);
  
  // 현재까지의 최솟값과 앞에서 구한 최솟값을 비교
  min = Math.min(min, count);
}
```

