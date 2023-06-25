## List 집합 구하는 방법

1. List의 교집합

```java
arrayList1.retainAll(arrayList2);
```

</br>

2. List의 부분집합

```java
arrayList1.containAll(arrayList2); // arrayList2는 arrayList1의 부분집합인가?
```

</br>

3. List의 차집합

```java
arrayList1.removeAll(arrayList2); // arrayList1 - arrayList2
```

</br>

4. List의 합집합

```java
arrayList1.addAll(arrayList2); // 중복을 제거해주지 않는다.

HashSet<String> union = new HashSet<>();
union.addAll(arrayList1); // 중복 제거
```

