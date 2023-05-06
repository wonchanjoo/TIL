# 투 포인터

- **연속적인 값**들을 이용해 푸는 문제에 적합
- 길이가 **가변**적인 부분 배열을 활용하는 경우에 적합

</br>

### ✔️ 유형

1. 2개의 포인터 변수 시작점이 배열의 시작점인 경우
2. 정렬된 배열 안에서 2개의 포인터 변수가 각각 시작점과 끝점에 위치한 경우

</br>

### ✔️ 2개의 포인터의 이동 조건

1. 부분 배열의 합 >= target
   - start++
   - 같은 경우에도 늘려주는 이유는 다음 배열을 탐색해야 하기 때문
2. 부분 배열의 합 < target
   - end++
3. 부분 배열의 합 == target
   - count++

</br>

## 👾 백준

```java
public class Main {
  	public static void main(String[] args) throws IOEXception {
      	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      	
      	int N = Integer.parseInt(br.readLine());
      
      	int start = 1, end = 1;
      	int sum = 1, count = 0;
      
      	while(start <= end) {
          	if(sum == N) {
              count++;
            }
          	
          	if(sum >= N) {
              	sum -= start;
              	start++;
            } else {
              	end++;
              	sum += end;
            }
        }
      
      	System.out.println(count);
    }
}
```

