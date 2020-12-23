import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178 {
    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++){
            String input = br.readLine();
            for (int j = 0; j < m; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        visit[0][0] = true;
        while (!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if ((0 <= nx && nx < n) && (0 <= ny && ny < m)){
                    if (map[nx][ny] == 1 && !visit[nx][ny]){
                        q.add(new Pair(nx, ny));
                        map[nx][ny] = map[p.x][p.y] + 1;
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
