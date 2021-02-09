#include <stdio.h>
#include <math.h>
#define MAX 300001

int p;
int visit[MAX];

void dfs(int num){
	visit[num]++;
	if (visit[num] == 3)
		return;
	int next = 0;
	while (num){
		next += pow(num%10, p);
		num /= 10;
	}
	dfs(next);
}

int main(){
	int a;
	scanf("%d %d", &a, &p);
	dfs(a);
	int result = 0;
	for (int i = 0; i < MAX; i++){
		if (visit[i] == 1)	result++;
	}
	printf("%d\n", result);
	return 0;
}
