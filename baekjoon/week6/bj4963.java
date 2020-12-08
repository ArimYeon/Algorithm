import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj4963 {
    static int w, h;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
    static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };

    public static void dfs(int i, int j){
        visit[i][j] = true;
        for (int a = 0; a < 8; a++){
            int x = i + dx[a];
            int y = j + dy[a];
            if (0<=x && x<h && 0<=y && y<w){
                if (map[x][y] == 1 && !visit[x][y])
                    dfs(x, y);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0)   break;
            map = new int[h+1][w+1];
            visit = new boolean[h+1][w+1];
            for (int i = 0; i < h; i++){
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < w; j++)
                    map[i][j] = Integer.parseInt(input[j]);
            }
            int cnt = 0;
            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    if (map[i][j] == 1 && !visit[i][j]){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
