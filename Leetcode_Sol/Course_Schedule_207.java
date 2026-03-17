import java.util.ArrayList;

class Course_Schedule_207 {
      public boolean canFinish(int numCourses, int[][] prerequisites) {
            int n = numCourses;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                  list.add(new ArrayList<>());
            }
            for (int i = 0; i < prerequisites.length; i++) {
                  int a = prerequisites[i][0];
                  int b = prerequisites[i][1];
                  list.get(b).add(a);
            }
            int[] visited = new int[numCourses];
            for (int i = 0; i < n; i++) {
                  if (visited[i] == 0) {
                        if (dfs(list, visited, i) == false) {
                              return false;
                        }
                  }
            }

            return true;
      }

      private boolean dfs(ArrayList<ArrayList<Integer>> list, int[] visited, int u) {
            visited[u] = 1;
            for (int i = 0; i < list.get(u).size(); i++) {
                  if (visited[list.get(u).get(i)] == 1) {
                        return false;
                  }
                  if (visited[list.get(u).get(i)] == 0)
                        if (dfs(list, visited, list.get(u).get(i)) == false)
                              return false;
            }
            visited[u] = 2;
            return true;
      }
}