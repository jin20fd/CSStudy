## [수 찾기](https://www.acmicpc.net/problem/1920)
### 문제 풀이 방식
이미 정렬되어 있는 수열이어야 이분탐색이 가능하므로 입력받은 A 수열을 오름차순 정렬해주었습니다.
시작지점 인덱스인 `s`, 끝지점 인덱스인 `e`, 중간지점 인덱스인 `m`을 변수로 두어 활용하였습니다.
중간지점의 값을 찾으려는 값과 비교하여 탐색 범위를 절반으로 줄여 나갑니다.
```java
public static int binarySearch(int x) {
  int s = 0;
  int e = N - 1;
  while (s <= e) {
    int m = (s + e) / 2;
    if (A[m] == x) {
      return 1;
    } else if (A[m] < x) { // 찾으려는 값이 더 크므로 탐색 범위를 중간 지점 이후의 값들로 변경
      s = m + 1;
    } else if (A[m] > x) { // 찾으려는 값이 더 작으므로 탐색 범위를 중간 지점 이전의 값들로 변경
      e = m - 1;
    }
  }
  return 0;
}
```
