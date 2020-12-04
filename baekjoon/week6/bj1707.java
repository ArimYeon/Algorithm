import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj1707 {
    static ArrayList<Integer>[] graph;
    static int[] color;
    static boolean ans;

    public static void dfs(int start){
        for (int next : graph[start]){
            if (color[next]!=0 && color[start]!=0 && color[start]==color[next]) {
                ans = false;
                break;
            }
            if (color[next] == 0){
                if (color[start] == 1)  color[next] = 2;
                else    color[next] = 1;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0){
            String[] s1 = br.readLine().split(" ");
            int v = Integer.parseInt(s1[0]);
            int e = Integer.parseInt(s1[1]);
            graph = new ArrayList[v+1];
            for (int i = 1; i <= v; i++){
                graph[i] = new ArrayList<>();
            }
            color = new int[v+1];
            for (int i = 0; i < e; i++){
                String[] s2 = br.readLine().split(" ");
                int a = Integer.parseInt(s2[0]);
                int b = Integer.parseInt(s2[1]);
                graph[a].add(b);
                graph[b].add(a);
            }
            ans = true;
            for (int i = 1; i <= v; i++){
                if (color[i] == 0){
                    color[i] = 1;
                    dfs(i);
                }
            }
            if (ans)    System.out.println("YES");
            else    System.out.println("NO");
        }
    }
}
