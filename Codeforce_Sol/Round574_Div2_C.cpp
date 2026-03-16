#include <bits/stdc++.h>
using namespace std;
int main()
{
      int n;
      cin >> n;
      long long v[3][n];
      for (int i = 0; i < n; i++)
      {
            cin >> v[1][i];
      }
      for (int i = 0; i < n; i++)
      {
            cin >> v[2][i];
      }
      long long dp[4][n];
      dp[1][0] = 0;
      dp[2][0] = 0;
      dp[3][0] = 0;
      for (int i = 1; i <= n; i++)
      {
            dp[1][i] = max(max(dp[2][i - 1] + v[1][i - 1], dp[3][i - 1] + v[1][i - 1]), v[1][i - 1]);
            dp[2][i] = max(max(dp[1][i - 1] + v[2][i - 1], dp[3][i - 1] + v[2][i - 1]), v[2][i - 1]);
            dp[3][i] = max(dp[1][i - 1], dp[2][i - 1]);
      }
      cout << max(max(dp[1][n], dp[2][n]), dp[3][n]);
      return 0;
}