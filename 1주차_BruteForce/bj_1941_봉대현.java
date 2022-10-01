import java.util.*;
import java.io.*;

public class bj_1941_봉대현 {
    static char map[][];
    static int dx[] = {0,1,-1,0};
    static int dy[] = {1,0,0,-1};
    static ArrayList<int []> combi;
    static int ans;
    static int pick[];


    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        combi = new ArrayList<>();
        pick = new int[7];

        for (int i =0 ; i < 5; i++){
            String str = in.readLine();
            for(int j=0; j < 5; j++){
                map[i][j] = str.charAt(j);
                combi.add(new int[]{i,j});
            }
        }
        process(0,0);
        //Combination(new int[7],0,0,7);
        System.out.println(ans);
    }

    private static void Combination(int pick[],int cnt,int count, int end){

        if(end == 0){
            bfs(pick);
            return ;
        }

        if(count == 25) return;

        pick[cnt] = count;
        Combination(pick,cnt+1,count+1,end-1); // 선택
        Combination(pick,cnt,count+1,end); // 미선택
    }

    private static void process(int start,int cnt){
        if(cnt == 7){
            bfs(pick);
            return;
        }

        for(int i = start; i < 25; i++){
            pick[cnt] = i;
            process(i+1,cnt+1);
        }
    }

    private static void bfs(int pick[]){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean visited[] = new boolean[7];
        int s_num =0, total_num =1;

        q.add(pick[0]);
        visited[0] = true;

        while(!q.isEmpty()){
            int cnt = q.poll();
            int x = combi.get(cnt)[0];
            int y = combi.get(cnt)[1];
            if(map[x][y] == 'S') s_num++;

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                for(int next = 1; next < 7; next++){//7개의 노드가 연결되어있는지 판단
                    if(!visited[next] && nx == combi.get(pick[next])[0] && ny == combi.get(pick[next])[1])
                    {
                        q.offer(pick[next]);
                        visited[next] = true;
                        total_num++;
                    }
                }
            }
        }

        if(total_num == 7 && s_num >= 4){
            ans++;
        }

    }
}
