#include <bits/stdc++.h>
using namespace std;
int main()
{
      int n;
      cin >> n;
      vector<pair<int, int>> v(n);
      for (int i = 0; i < n; i++)
      {
            cin >> v[i].first;
            cin >> v[i].second;
      }
      sort(v.begin(), v.end());
      int lastday = min(v[0].first, v[0].second);
      for (int i = 0; i < n; i++)
      {
            if (v[i].second >= lastday)
            {
                  lastday = v[i].second;
            }
            else
            {
                  lastday = v[i].first;
            }
      }
      cout << lastday;
      return 0;
}