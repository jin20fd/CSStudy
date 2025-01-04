## [게임을 만든 동준이](https://www.acmicpc.net/problem/2847)
### 문제 풀이 방식
가장 높은 레벨부터 확인하면서 자신보다 더 낮은 레벨의 점수가 같거나 높다면 자신보다 하나 더 낮은 레벨을 갖도록 합니다. 
`int diff = score[lower] - score[cur] + 1;` 빼주어야 하는 값을 diff 변수에 저장하여 줍니다.  
그리고 diff 변수의 값만큼 빼어서 낮은 레벨의 점수를 갱신하고, result 변수에도 더해주어서 정답으로 출력합니다.


## [크게 만들기](https://www.acmicpc.net/problem/2812)
### 문제 풀이 방식
**맨 앞에서 K만큼 확인하여 큰 수만 선택하기**  
입력받은 숫자들을 앞에서부터 K만큼 확인하고 그 중 큰 수를 결과에 해당하는 resut배열에 넣습니다.
건너뛴만큼 K는 감소시켜 K가 0이 되면 해당 원소들은 모두 result배열에 넣어줍니다.

```java
while (i < N) {
  int maxN = nums[i];
  int maxIdx = 0;
  for (int j = 1; j <= K; j++) {
    if (maxN < nums[i + j]) {
      maxN = nums[i + j];
      maxIdx = j;
    }
  }
  result.add(nums[i + maxIdx]);
  K -= maxIdx;
  i += maxIdx + 1;
}
```
해당 방법으로는 O(N^2) 만큼의 시간이 걸리는데 N이 50만이므로 시간초과가 발생하였는데, 해결하지 못해서 결국 질문 게시판을 참고하였습니다.

**스택 활용**  
- 처음에 생각한 방식 : 입력받은 숫자에서 비교해서 큰 숫자를 결과에 넣는다
- 스택을 활용하는 방식 : 우선 결과에 넣어보고 더 큰 숫자로 대체 할 수 있으면 결과를 변경한다

스택을 활용하는 방식에서는 이미 확인한 숫자는 다시 확인하지 않기 떄문에 시간 초과가 발생하지 않습니다.

result를 배열이 아닌 스택으로 선언합니다.  
입력받은 배열을 순회하며 배열에서의 현재 원소와 스택의 값을 비교하여 스택의 값이 더 작다면 스택에서 해당 원소를 제거합니다.

```java
for (int i = 0; i < N; i++) {
  while (!result.isEmpty() && result.peek() < nums[i] && K > 0) {
    result.pop();
    K--;
  }
  result.push(nums[i]);
}
```

입력받은 배열을 순회하고도 K가 0이 되지 않으면, K가 0이 될때까지 스택의 맨 끝 값을 제거해줍니다.

```java
while (K > 0) {
  result.pop();
  K--;
}
```
