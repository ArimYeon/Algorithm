#include <iostream>
using namespace std;

int graph[1001];
bool visit[1001];

void dfs(int start){
	visit[start] = true;
	int next = graph[start];
	if (visit[next] == false)
		dfs(next);
}

int main(){
	ios::sync_with_stdio(false); cin.tie(NULL);
	int t;
	cin >> t;
	while (t--){
		int v;
		cin >> v;
		for (int i = 1; i <= v; i++){
			int a;	cin >> a;
			graph[i] = a;
			visit[i] = false;
		}
		int ans = 0;
		for (int i = 1; i <= v; i++){
			if (visit[i] == false){
				ans++;
				dfs(i);
			}
		}
		cout << ans << "\n";
	}
	return 0;
}
