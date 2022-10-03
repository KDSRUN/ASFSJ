import java.io.*;
import java.util.*;

class bj_2785_김준환 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chainCnt = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>();
        while(st.hasMoreTokens()){
            pq.offer(stoi(st.nextToken()));
        }

        int openCnt = 1;
        while(!pq.isEmpty()){
            int i = pq.poll();
            if(openCnt + i >= chainCnt){
                break;
            }
            openCnt += i;
            chainCnt -= 1;
        }

        System.out.println(chainCnt - 1);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
