import java.util.*;
import java.util.stream.*;

public class BOJ16964 {
  static int N;
  static LinkedList<Integer>[] nodes;
  static int[] visitOrder;
  static boolean[] visited;
  static ArrayList<Integer> result;

  static void dfs(int cur) {
    result.add(cur);

    for (int e : result) {
      System.out.print(e + " ");
    }
    System.out.println();
      
    for (int next : nodes[cur]) {
      if (!visited[next]) {
        visited[next] = true;
        dfs(next);
        visited[next] = false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    N = scanner.nextInt();

    nodes = new LinkedList[N+1];
    visited = new boolean[N+1];
    Arrays.fill(visited, false);
    for (int i = 1; i <= N; i++) {
      nodes[i] = new LinkedList<>();
    }

    for (int i = 0; i < N-1; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      nodes[a].add(b);
      nodes[b].add(a);
    }

    visitOrder = new int[N+1];
    for (int i = 0; i < N; i++) {
      visitOrder[i] = scanner.nextInt();
    }

    result = new ArrayList<>();
    int start = visitOrder[0];
    // result.add(start);
    visited[start] = true;
    dfs(start);

    scanner.close();
  }
}
