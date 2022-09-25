import java.io.*;
import java.util.*;

class bj_10819_김준환 {
    static int N;
    static int[] arr, sArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = stoi(st.nextToken());
        }

        sArr = new int[N];
        selected = new boolean[N];
        max = 0;
        perm(0);

        System.out.println(max);
    }

    static boolean[] selected;
    static int max;
    static void perm(int n){
        if(n == N){
            // 차이계산
            int dif = 0;
            for(int i = 0; i < N - 1; i++){
                dif += Math.abs(sArr[i] - sArr[i + 1]);
            }
            max = Math.max(max, dif);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!selected[i]){
                selected[i] = true;
                sArr[n] = arr[i];
                perm(n + 1);
                selected[i] = false;
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
