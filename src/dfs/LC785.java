package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC785 {
    private boolean isBinary = true;
    private int[] state;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        state = new int[n];
        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                dfs(graph, i, 1);
                if (!isBinary) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(int[][] graph, int index, int s) {
        state[index] = s;
        int ns = s == 1 ? 2 : 1;
        for (int newIndex : graph[index]) {
            if (state[newIndex] == 0) {
                dfs(graph, newIndex, ns);
                if (!isBinary) {
                    return;
                }
            } else if (state[newIndex] != ns) {
                isBinary = false;
                return;
            }
        }
    }

    public boolean isBipartite_bfs(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        for (int i = 0; i < n; i++) {
            if (state[i] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            state[i] = 1;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int ns = state[cur] == 1 ? 2 : 1;
                for (int index : graph[cur]) {
                    if (state[index] == 0) {
                        state[index] = ns;
                        queue.offer(index);
                    } else if (state[index] != ns) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };
        LC785 sln = new LC785();
        boolean res = sln.isBipartite(graph);
        System.out.println(res);
    }
}
