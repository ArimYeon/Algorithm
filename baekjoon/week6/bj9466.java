import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9466 {
    static int[] graph;
    static boolean[] visit, counted;
    static int cnt;

    public static void dfs(int start){
        visit[start] = true;
        int next = graph[start];
        if (!visit[next])
            dfs(next);
        else if (!counted[next]){
            for (int i = next; i != start; i = graph[i]) cnt++;
            cnt++;
        }
        counted[start] = true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            graph = new int[n+1];
            visit = new boolean[n+1];
            counted = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++)
                graph[i] = Integer.parseInt(st.nextToken());
            cnt = 0;
            for (int i = 1; i <= n; i++){
                if (!visit[i])
                    dfs(i);
            }
            System.out.println(n-cnt);
        }
    }
}
