/**
 * 1 ~ 9999 까지 판별
 *
 * 소수이면 다음 자리수 판별 (dfs)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_2023_김다은 {

    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        dfs(0, "");

        System.out.print(sb);
    }

    private static void dfs(int cnt, String num) {
        if(cnt == N){
            sb.append(num).append("\n");
            return;
        }

        for(int i = 1; i <= 9; i++){
            if(prime(num + i)){
                dfs(cnt + 1, num + i);
            }
        }
    }

    private static boolean prime(String num) {
        int num2 = Integer.parseInt(num);
        int root = (int) Math.sqrt(num2);
        boolean isPrime = true;

        if (num2 == 1) isPrime = false;   // 1은 소수 아님

        for (int i = 2; i <= root; i++) {
            if (num2 % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}