import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7576 {
    static int m, n;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void checkMap(){
        int max = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max-1);
    }

    public static void bfs(){
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 1){
                    q.add(new Pair(i, j));
                }
            }
        }
        while (!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if ((0 <= nx && nx < n) && (0 <= ny && ny < m)){
                    if (map[nx][ny] == 0){
                        q.add(new Pair(nx, ny));
                        map[nx][ny] = map[p.x][p.y] + 1;
                    }
                }
            }
        }
        checkMap();
    }

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        bfs();
    }
}
