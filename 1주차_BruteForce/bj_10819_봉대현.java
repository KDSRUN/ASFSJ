import java.util.*;
import java.io.*;

public class bj_10819_봉대현 {
    static int ans;
    static int pick[];
    static boolean isSel[];

    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int numList[] = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());

        for(int i = 0; i < N; i++){
            numList[i] = Integer.parseInt(st.nextToken());
        }
        pick = new int[N];
        isSel = new boolean[N];

        process(N,0,numList);
        System.out.println(ans);
    }

    private static void process(int end, int cnt, int []numList){

        if(cnt == end){
            int newVal=cal(pick);
            ans = Math.max(newVal,ans);
        }


        for(int i = 0; i < end; i++){
            if(isSel[i]) continue;
            isSel[i]= true;
            pick[cnt] = numList[i];
            process(end,cnt+1, numList);
            isSel[i] = false;
        }
    }

    private static int cal(int []pick){
        int sum=0;

        for(int i = 0;i < pick.length - 1; i++){
            sum += Math.abs(pick[i] - pick[i+1]);
        }

        return sum;
    }
}
