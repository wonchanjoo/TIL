## 방법 1 - 3중 for문 사용

```java
private static int search() {
    int result = 0;

    // 3개의 카드를 고르기 때문에 첫 번째 카드는 N - 2 까지만 순회
    for(int i = 0; i < N - 2; i++) {
        // 두 번째 카드는 N - 1 까지만 순회
        for(int j = i + 1; j < N - 1; j++) {
            // 세 번째 카드는 N 까지만 순회
            for(int k = j + 1; k < N; k++) {
                int temp = card[i] + card[j] + card[k];

                if(M == temp) {
                    return temp;
                }

                if(temp < M && temp > result) {
                    result = temp;
                }
            }
        }
    }

    return result;
}
```

- 최악의 경우 O(N^3)의 복잡도

</br>

## 방법 2

```java

```

- 카드 한 장이 이미 M보다 크면 탐색할 필요가 없다.
- 카드 두 장의 합이 M보다 크면 탐색할 필요가 없다.