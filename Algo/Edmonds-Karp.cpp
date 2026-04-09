#include<bits/stdc++.h>

using namespace std;

const int MAXN = 1001;
int n, m,s,t;
vector<int> adj[MAXN];
int c[MAXN][MAXN], f[MAXN][MAXN], trace[MAXN], maxflow;

void bfs(){
      fill(trace,trace+n+1,0);
      trace[s] = -1;
      queue<int> bfsQueue;

      bfsQueue.push(s);

      while (!bfsQueue.empty()){
            int u = bfsQueue.front();
            bfsQueue.pop();
            for (auto v: adj[u]){
                  if (trace[v]) continue;

                  if (f[u][v] - c[u][v] ==0) continue;

                  trace[v] = u;
                  bfsQueue.push(v);
            }
      }
}
void incFlow(){
      int delta = INT_MAX;
      int v = t;
      while (v!=s){
            int u = trace[v];
            delta = min(delta,c[u][v]-f[u][v]);
            v=u;
      }

      maxflow+=delta;

      v = t;
      while (v!=s){
            int u = trace[v];
            f[u][v] += delta;
            f[v][u] -= delta;
            v = u;
      }
}
int main(){
      cin>>n>>m>>s>>t;
      for (int u,v,i=1;i<=m;i++){
            cin>>u>>v;
            cin>>c[u][v];
            adj[u].push_back(v);
            adj[v].push_back(u);
      }

      maxflow = 0;

      do{
            bfs();
            if (trace[t]) incFlow;
      } while(trace[t]);

      cout<<maxflow;
}