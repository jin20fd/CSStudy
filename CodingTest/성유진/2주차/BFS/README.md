## [그림](https://www.acmicpc.net/problem/1926)
### 문제 풀이 방식
0~n-1, 0~m-1 중에 방문하지 않았고, 그림에 해당하는 board[i][j]가 1인 경우를 시작점으로 선정하여 bfs를 수행하였습니다.  
그리고 bfs를 수행하는 경우는 하나의 그림에 해당하기 때문에 그림개수를 하나씩 증가 시켜주었습니다.

bfs함수에서는 현재 위치에서 네 방향을 확인하여 방문하지 않았고 board값이 1인 경우에 방문하도록 하였습니다.  
그림의 크기는 큐에서 새로운 원소를 빼낼 때마다 하나씩 키워주고, bfs 방문이 모두 끝난 경우에 반환하도록 하였습니다.  

### java에서 pair 사용
java에는 pair가 없어서 큐에 원소의 위치 {i, j}를 배열로 넣어주었습니다.

```java
Queue<int[]> Q = new LinkedList<>();
// 원소 삽입
Q.offer(new int[]{ni, nj});

// 원소 제거
int[] cur = Q.poll();
int curi = cur[0];
int curj = cur[1];
```

