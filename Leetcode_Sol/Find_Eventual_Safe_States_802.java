import java.util.ArrayList;
import java.util.List;

class Find_Eventual_Safe_States_802 {
      public List<Integer> eventualSafeNodes(int[][] graph) {
            List<Integer> res = new ArrayList<>();
            int n = graph.length;
            int[] vis = new int[n];
            for (int i = 0; i < n; i++) {
                  if (dfs(i, graph, vis)) {
                        res.add(i);
                  }
            }
            return res;
      }

      boolean dfs(int node, int[][] graph, int[] vis) {
            if (vis[node] == 2) {
                  return true;
            }
            if (vis[node] == 1) {
                  return false;
            }
            vis[node] = 1;
            for (int neghbor : graph[node]) {
                  if (!dfs(neghbor, graph, vis)) {
                        return false;
                  }
            }
            vis[node] = 2;
            return true;
      }
}