import java.util.*;
import java.io.*;

/*
1. 왼쪽 오른쪽 번갈아가면서 미네랄 지운다.
2. 클러스터를 찾는다.
3. 클러스터가 다른 클러스터나 땅을 만나기 전까지 떨어진다.
 */

public class bj_2933_봉대현 {
    static int R, C, N;
    static char board[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static int cluster[][];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String text = in.readLine();

            for (int j = 0; j < C; j++) {
                board[i][j] = text.charAt(j);
            }
        }

        N = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());


        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken()); //던질 높이
            deleteMineral(R - height, i % 2);//미네랄 지우기
            setCluster();
        }

        printBoard();
    }

    private static void setCluster() {

        //클러스터 찾기
        cluster = new int[R][C];
        int cnt = 1; //클러스터 그룹 번호

        for (int i = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'x' && cluster[i][j] == 0)//미네랄이고 미방문일 경우
                {
                    if (findCluster(i, j, cnt)) return;
                }

            }
        }
    }

    private static boolean findCluster(int i, int j, int cnt) {
        int low_height = Integer.MIN_VALUE;

        ArrayDeque<Node> q = new ArrayDeque();
        ArrayList<Node> list = new ArrayList<>();

        q.offer(new Node(i, j));
        cluster[i][j] = cnt;

        while (!q.isEmpty()) {

            Node cnt_node = q.poll();
            //땅과 제일 가까운 높이 구하기
            low_height = Math.max(low_height, cnt_node.x);
            //4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = cnt_node.x + dx[d];
                int ny = cnt_node.y + dy[d];

                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    if (cluster[nx][ny] == 0 && board[nx][ny] == 'x') {
                        cluster[nx][ny] = cnt;
                        q.offer(new Node(nx, ny));
                    }
                }
            }

            list.add(cnt_node);
        }

        if (low_height != R - 1) {//땅바닥 위에 있는 경우(공중)
            downBoard(list);
            return true;
        }


        return false;

    }

    private static void downBoard(ArrayList<Node> list) {
        int down = 1;

        for (Node node : list) {
            board[node.x][node.y] = '.';
        }
        boolean flag = true;

        while (flag) {

            for (Node node : list) {
                if (node.x + down == R || board[node.x + down][node.y] == 'x') {
                    down--;
                    flag = false;
                    break;
                }
            }
            if (flag){
                down++;
            }

        }

        for (Node node : list) {
            board[node.x + down][node.y] = 'x';
        }
    }

    private static void deleteMineral(int height, int direction) {
        //d - 0  Left 1  Right

        if (direction == 0) {//Left
            for (int i = 0; i < C; i++) {
                if (board[height][i] == 'x') {
                    board[height][i] = '.';
                    return;
                }
            }
        } else {//Right
            for (int i = C - 1; i >= 0; i--) {
                if (board[height][i] == 'x') {
                    board[height][i] = '.';
                    return;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    private static void printBoard() {

        for (int i = 0; i < R; i++) {

            for(int j =0; j < C; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
