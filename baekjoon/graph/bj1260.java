import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1260 {
    static int n;
    static boolean visit[];
    static boolean graph[][];

    public static void dfs(int v){
        visit[v] = true;
        System.out.print(v+" ");
        for (int i = 1; i <= n; i++)
            if (graph[v][i] && !visit[i])   dfs(i);
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visit[v] = true;
        while (!q.isEmpty()){
            int front = q.poll();
            System.out.print(front+" ");
            for (int i = 1; i <= n; i++){
                if (graph[front][i] && !visit[i]){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graph = new boolean[n+1][n+1];
        visit = new boolean[n+1];
        for (int i = 0; i < n + 1; i++)
            Arrays.fill(graph[i], false);
        Arrays.fill(visit, false);
        for (int i = 0; i < m; i++){
            String edge = br.readLine();
            StringTokenizer edgeSt = new StringTokenizer(edge, " ");
            int a = Integer.parseInt(edgeSt.nextToken());
            int b = Integer.parseInt(edgeSt.nextToken());
            graph[a][b] = graph[b][a] = true;
        }
        dfs(v);
        System.out.println();
        Arrays.fill(visit, false);
        bfs(v);
    }
}
