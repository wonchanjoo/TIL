# 그리디 알고리즘(Greedy Algorithm)

- **매 선택에서 현재 당장 최적인 답을 선택**해 적합한 결과를 도출하는 알고리즘 기법
- 백트래킹을 통해 추가 점검을 하지 않고 현재 조건에서 선택을 했다면 더 이상 다른 선택 가능 경우는 검증하지 않는다.
- 항상 최적해가 되지 않으므로 **1. 탐욕 선택 속성(Greedy Choice Property)**와 **2. 최적 부분 구조(Optimal Substructure)** 2가지 조건을 만족해야 한다.
- 일반적으로 그리디임을 증명하려면 수학적 증명이 동반되어야 하지만 어렵다. 따라서 반례를 찾아서 그리디가 아님을 증명한다.

</br>

##### 1. 탐욕 선택 속성(Greedy Choice Property)

- 이전의 선택이 이후에 영향을 주지 않는다.

##### 2. 최적 부분 구조(Optimal Substructure)

- 부분 문제의 최적결과가 전체에도 그대로 적용될 수 있어야 한다.

</br>

## 🏋️ Action Selection 문제

- 그리디 알고리즘의 가장 대표적인 예시
- N개의 활동이 있고 각 활동에는 시작 시간 및 종료 시간이 있을 때, 한 사람이 최대한 많이 할 수 있는 활동(Activity)의 수를 구하는 문제
- 각각의 활동(Activiry)에는 시간이 소요되므로 하나를 선택했다면 그 동안 해당 시간에 다른 Activiry를 할 수 없다.

|   활동 이름   | A    |  B   |  C   |  D   |  E   |  F   |
| :-----------: | ---- | :--: | :--: | :--: | :--: | :--: |
| **시작 시간** | 7    |  5   |  3   |  1   |  6   |  10  |
| **종료 시간** | 8    |  7   |  6   |  2   |  9   |  11  |

- 최대한 많은 활동을 해야하므로 언제 시작하든 전체에서 **가장 종료 시간이 빠른 것**부터 선택해야 한다. 어차피 시작 시간은 종료 시간 이전이므로 고려하지 않는다.
- 따라서 종료 시간을 기준으로 정렬한 뒤, 제일 먼저 끝나는 활동을 무조건 선택하고 끝났을 때, 바로 다음에 선택할 수 있는 활동을 찾아 수행하는 방식을 반복하여 해결할 수 있다.

```java
public class Main {
  public static void main(String[] args) {
    // 활동 정보를 List에 저장하고 정렬한다.
    ArrayList<Action> list = new ArrayList<>();
    list.add(new Action("A", 7, 8));
    list.add(new Action("B", 5, 7));
    list.add(new Action("C", 3, 6));
    list.add(new Action("D", 1, 2));
    list.add(new Action("E", 6, 9));
    list.add(new Action("F", 10, 11));
    Collections.sort(list);
    
    // Greedy 알고리즘 수행 후, 결과 출력
    ArrayList<Action> ans = greedy(list);
    for(Action act : ans) {
      System.out.println(acr.name + ", ");
    }
  }
  
  // Greedy 알고리즘을 통해 선택된 활동들을 반환한다.
  private static ArrayList<Action> greedy(ArrayList<Action> list) {
    int time = 0;
    ArrayList<Action> ans = new ArrayList<>();
    
    for(Action act : list) {
      if(time <= act.startTime) {
        time = act.endTime;
        ans.add(act);
      }
    }
    return ans;
  }
  
  class Action implements Comparable<Action> {
    String name;
    int startTime;
    int endTime;
    public Action(String name, int startTime, int endTime) {
      this.name = name;
      this.startTime = startTime;
      this.endTime = endTime;
    }
    
    @Override
    public int compareTo(Action a) {
      return this.endTime - a.endTime;
    }
    
    @Override
    public String toString() {
      return this.name;
    }
  }
}
```

</br>

## 💸 거스름돈 문제

- 돈을 낸 뒤, 거스름돈을 최소 개수의 동전 및 지폐의 조합으로 주는 경우 그 개수를 구하는 문제
- MSD(Most Significant Digit, 가장 중요한 단위를 먼저 계산)를 이용
  - 자신보다 더 큰 지폐 혹은 동전으로 거스름돈을 준다면 나머지는 무조건 더 적은 개수로 반환하는 것이 가능하기 때문에 이를 사용할 수 있다.
- 따라서 이전의 선택과 관련 없이 **현재 상태에서 최선의 결과를 선택하여 전체에서 최적의 결과**를 낼 수 있다.

### ‼️ 반례

- 동전의 종류가 50원, 40원, 10원이 있고 거스름돈이 120원인 경우
  - MSD 방식 적용: 50원 2개, 10원 2개 = 4개
  - 하지만 40원 3개를 거슬러주면 더 적은 개수로 거스름돈을 줄 수 있다.
- 40원이 자신보다 큰 동전(50원)의 약수가 아니기 때문이다. 50원은 40원을 대체해 더 적은 숫자로 반환하는 경우라고 보장할 수 없다.