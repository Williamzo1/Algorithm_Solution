class Validate_Binary_Tree_Node_1361 {
      public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            int[] inDegree = findInDegree(n, leftChild, rightChild);
            int root = -1;
            for (int i = 0; i < n; i++) {
                  if (inDegree[i] == 0) {
                        if (root != -1) {
                              return false;
                        } else {
                              root = i;
                        }
                  }
                  if (inDegree[i] > 1) {
                        return false;
                  }
            }
            if (root == -1)
                  return false;
            if (dfs(root, n, leftChild, rightChild) != n) {
                  return false;
            }
            return true;

      }

      private int[] findInDegree(int n, int[] leftChild, int[] rightChild) {
            int[] inDegree = new int[n];
            for (int i = 0; i < n; i++) {
                  if (leftChild[i] != -1) {
                        inDegree[leftChild[i]]++;
                  }
                  if (rightChild[i] != -1) {
                        inDegree[rightChild[i]]++;
                  }
            }
            return inDegree;
      }

      private int dfs(int u, int n, int[] leftChild, int[] rightChild) {
            if (u == -1)
                  return 0;
            return dfs(leftChild[u], n, leftChild, rightChild) + dfs(rightChild[u], n, leftChild, rightChild) + 1;
      }
}