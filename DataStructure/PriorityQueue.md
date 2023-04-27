# Java - Priority Queue

- 일반적인 큐의 구조 FIFO(First In First Out)를 가지면서, 데이터가 들어온 순서대로 데이터가 나가는 것이 아닌 우선순위를 먼저 결정하고 그 우선순위가 높은 데이터가 먼저 나가는 자료구조
- 우선순위 큐에 저장할 객체는 Comparable Interface를 구현해야한다.
  - compareTo method를 override 하게 되고 해당 객체에서 처리할 우선순위 조건을 리턴해주면 PriorityQueue가 알아서 우선순위가 높은 객체를 추출해준다.
- Heap을 이용하여 구현하는 것이 일반적이다.
  - 데이터를 삽입할 때 우선순위를 기준으로 최대 힙 혹은 최소 힙을 구성하고 데이터를 꺼낼 때 루트 노드를 얻어낸 뒤 루트 노드를 삭제할 때는 빈 루트 노드 위치에 맨 마지막 노드를 삽입한 후 아래로 내려가면서 적절한 자리를 찾아 옮기는 방식으로 진행된다.

> 최댓 값이 우선순위인 큐 = 최대 힙, 최솟 값이 우선순위인 큐 = 최소 힙

</br>

### Priority Queue 특징

- 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조
- 내부 요소는 힙으로 구성된 이진트리 구조
- 내부 구조가 힙으로 구성되어 있기에 시간 복잡도는 O(NlogN)
- 우선순위를 중요시해야 하는 상황에서 주로 사용

</brr>

### Priority Queue 사용

```java
import java.util.PriorityQueue;
import java.util.Collections;

// 낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();

// 높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
```

