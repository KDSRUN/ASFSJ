import java.util.*;
import java.io.*;

public class bj_18428_봉대현 {
    static int N,ans,student;
    static char [][]board;
    static ArrayList<Teacher> teachers;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};

    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        board = new char[N][N];
        teachers = new ArrayList<>();


        for(int i=0;i<N;i++){
            String []input = in.readLine().split(" ");
            for(int j=0;j<N;j++){
                board[i][j] = input[j].charAt(0);
                if(board[i][j] == 'T'){
                    teachers.add(new Teacher(i,j));
                } else if (board[i][j] == 'S') {
                    student++;
                }
            }
        }

        setBlock(0);
        System.out.println(ans==0 ? "NO" : "YES");
    }

    private static void setBlock(int cnt){

        if(cnt == 3){
            char copyMap[][] = new char[N][N];
            for(int i=0;i<N;i++) {
                for (int j = 0; j < N; j++) {
                    copyMap[i][j] = board[i][j];
                }
            }

            copyMap = watch(copyMap);

            int studentNum = 0;
            for(int i=0;i<N;i++) {
                for (int j = 0; j < N; j++) {
                    if(copyMap[i][j] == 'S'){
                        studentNum++;
                    }
                }

            }
            //모든 학생들이 피할수 있으면 Yes 없으면 No
            if(studentNum == student) ans = 1;
            return ;
        }

        if(ans == 1){
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if( board[i][j] != 'X') continue;
                board[i][j] = 'O';
                setBlock(cnt+1);
                board[i][j] = 'X';
            }
        }
    }

    private static char[][] watch(char [][]copyMap){

        for(Teacher teacher : teachers){
            for(int d = 0; d < 4; d++){
                int nx = teacher.x;
                int ny = teacher.y;

                while(true){
                    nx += dx[d];
                    ny += dy[d];

                    if(0 > nx || nx >= N || 0 > ny || ny >= N){
                        break;
                    }
                    if(copyMap[nx][ny] == 'O') {
                        break;
                    }
                    if(copyMap[nx][ny] == 'S')
                        copyMap[nx][ny] = 'X';
                }
            }
        }

        return copyMap;
    }

    static class Teacher{
        int x;
        int y;

        public Teacher(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
