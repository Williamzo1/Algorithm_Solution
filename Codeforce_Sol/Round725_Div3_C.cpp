#include <bits/stdc++.h>
using namespace std;
int main()
{
      int t;
      cin >> t;
      while (t--)
      {
            int n;
            cin >> n;
            long long l, r;
            cin >> l >> r;
            vector<long long> v(n);
            for (int i = 0; i < n; i++)
            {
                  cin >> v[i];
            }
            sort(v.begin(), v.end());
            long long sol = 0;
            for (int i = 0; i < n; i++)
            {
                  int t = v[i];
                  sol += (upper_bound(v.begin() + i + 1, v.end(), r - t) - lower_bound(v.begin() + i + 1, v.end(), l - t));
            }
            cout << sol << endl;
      }
}