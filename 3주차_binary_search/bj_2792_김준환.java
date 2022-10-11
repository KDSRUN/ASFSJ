import java.io.*;
import java.util.*;

class bj_2792_김준환 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int[] jewels = new int[M];
        int max = 0;
        for(int m = 0; m < M; m++){
            int cnt = stoi(br.readLine());
            max = Math.max(max, cnt);
            jewels[m] = cnt;
        }

        // 이분탐색
        int left = 0, right = max;
        int mid = 0;
        while(left + 1 < right){
            mid = (left + right) / 2;
            boolean canGiveAll = true;
            int n = N;
            // 나눠주기
            for(int i = 0; i < M; i++){
                // 보석 수 / mid = 줄일 인원수
                // 나머지 있으면 줄일 인원수++
                int discount = jewels[i] / mid;
                if(jewels[i] % mid > 0){
                    discount++;
                }

                if(n >= discount){
                    n -= discount;
                }else{
                    canGiveAll = false;
                    break;
                }
            }
            // 나눠주기 가능하면 줄이기
            if(canGiveAll){
                right = mid;
            }else{
                left = mid;
            }
        }

        System.out.println(right);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
