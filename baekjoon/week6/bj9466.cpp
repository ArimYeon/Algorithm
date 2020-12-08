#include <iostream>
#include <string.h>
using namespace std;
#define MAX 100000

int graph[MAX+1];
bool visit[MAX+1], counted[MAX+1];
int cnt;

void dfs(int start){
	visit[start] = true;
	int next = graph[start];
	if (!visit[next])
		dfs(next);
	else if (!counted[next]){
		for (int i = next; i != start; i = graph[i])	cnt++;
		cnt++;
	}
	counted[start] = true;
}

int main(){
	ios::sync_with_stdio(false); cin.tie(NULL);
	int t; cin >> t;
	while (t--){
		int n; cin >> n;
		memset(visit, false, n+1);
		memset(counted, false, n+1);
		for (int i = 1; i <= n; i++)
			cin >> graph[i];
		cnt = 0;
		for (int i = 1; i <= n; i++){
			if (!visit[i]){
				dfs(i);
			}
		}
		cout << n-cnt << "\n";
	}
	return 0;
}
