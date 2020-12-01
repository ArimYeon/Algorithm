import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11724 {
    static int n;
    static boolean graph[][];
    static boolean visit[];

    public static void dfs(int v){
        visit[v] = true;
        for (int i = 1; i <= n; i++){
            if (graph[v][i] && !visit[i])   dfs(i);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new boolean[n+1][n+1];
        visit = new boolean[n+1];
        for (int i = 0; i < n+1; i++)
            Arrays.fill(graph[i], false);
        Arrays.fill(visit, false);
        while (m > 0){
            String s1 = br.readLine();
            StringTokenizer st1 = new StringTokenizer(s1, " ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            graph[a][b] = graph[b][a] = true;
            m--;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++){
            if (!visit[i]){
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
