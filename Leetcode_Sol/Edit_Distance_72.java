
public class Edit_Distance_72 {
      public int minDistance(String word1, String word2) {
            word1 = "-" + word1;
            word2 = "-" + word2;
            int len_1 = word1.length();
            int len_2 = word2.length();
            int[][] dp = new int[len_1][len_2];
            dp[0][0] = 0;
            for (int i = 0; i < len_2; i++) {
                  dp[0][i] = i;
            }
            for (int i = 0; i < len_1; i++) {
                  dp[i][0] = i;
            }

            for (int i = 1; i < len_2; i++) {
                  for (int j = 1; j < len_1; j++) {
                        if (word1.charAt(j) == word2.charAt(i)) {
                              dp[j][i] = dp[j - 1][i - 1];
                        } else {
                              dp[j][i] = Math.min(Math.min(dp[j - 1][i], dp[j][i - 1]), dp[j - 1][i - 1]) + 1;
                        }
                  }
            }
            return dp[len_1 - 1][len_2 - 1];
      }

}