import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10451 {
    static boolean visit[];

    public static void dfs(String[] graph, int start){
        visit[start] = true;
        int next = Integer.parseInt(graph[start - 1]);
        if (visit[next] == false)
            dfs(graph, next);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int v = Integer.parseInt(br.readLine());
            visit = new boolean[v+1];
            String[] graph = br.readLine().split(" ");
            int ans = 0;
            for (int i = 1; i <= v; i++){
                if (visit[i] == false){
                    ans++;
                    dfs(graph, i);
                }
            }
            System.out.println(ans);
        }
    }
}
