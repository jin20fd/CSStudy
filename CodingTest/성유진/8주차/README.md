## [좋다](https://www.acmicpc.net/problem/1253)
### 문제 풀이 방식
**입력받은 수열을 순회하면서 두 개의 숫자를 고르고, 두 숫자를 더한 수가 해당 수열에 존재하는지** 를 판단하여 문제를 해결하였습니다.  
하지만, 두 숫자를 더한 수의 존재여부를 다시 배열을 순회하여 확인하면 시간초과가 발생할 듯 하여 HashMap을 활용하여 O(1) 시간에 확인할 수 있도록 하였습니다.

즉, 입력 받은 수열을 배열과 HashMap에 모두 저장합니다.
- A(배열) : 입력받은 숫자를 그대로 저장
- M(맵) : key는 입력받은 수, value는 해당 수의 개수로 저장

*`수의 위치가 다르면 값이 같아도 다른 수이다.`* 라는 조건이 있어서 Set을 활용하려다가 중복되는 숫자의 개수까지 저장할 수 있도록 Map을 활용하였습니다.  
또한 좋은 수의 개수를 구할 때에 같은 수인 경우면 해당 수의 cnt를 Map 저장된 개수만큼 증가시켜주고 해당 숫자를 Map에서 제거해주었습니다.

```java
for (int i = 0; i < N - 1; i++) {
  for (int j = i + 1; j < N; j++) {
    int sumVal = A[i] + A[j]; // 배열 순회하며 선택한 두 수를 더한 값
    if (M.containsKey(sumVal) && !isSelf(A[i], A[j])) {
      cnt += M.get(sumVal); // 개수만큼 반영
      M.remove(sumVal);     // 맵에서 제거
    }
  }
}
```

예를 들어 `1 1 2 2 2 2 2` 와 같은 입력이 들어온다면,  
{1:2, 2:5} 와 같은 형식으로 Map에 저장하고, sumVal이 2가 되면 cnt에 M[2]의 값인 5를 더해주고, M에서 2를 제거합니다.

`0 -1 1` 와 같은 경우 예외처리를 하기 위해서 isSelf 함수를 만들었습니다.
기존 로직에 따르면 0 + (-1) = -1 로 -1이 Map에 존재하기 때문에 cnt가 증가합니다. 하지만 자기 자신이 포함되어 있기 때문에 cnt를 증가시키지 않아야 합니다.

```java
public static boolean isSelf(int a, int b) {
  int sumVal = a + b;
  if (a == sumVal && M.get(a) == 1) 
    return true;
  if (b == sumVal && M.get(b) == 1)
    return true;
  if (a == b && a == sumVal && M.get(a) == 2) // 0 0 에 대한 예외처리
    return true;
  return false;
}
```