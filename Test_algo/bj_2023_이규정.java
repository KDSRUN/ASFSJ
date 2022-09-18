import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_2023_이규정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] primes = {"2", "3", "5", "7"};
        for (int i=0; i<4; i++) {
            dfs(primes[i], 1, n);
        }
    }
    public static Boolean chkPrime(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i=2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void dfs(String num, int idx, int n) {
        int number = Integer.parseInt(num);
        if (!chkPrime(number)) {
            return;
        }
        else if (idx < n) {
            for (int i=0; i<10; i++) {
                String temp = num.concat(Integer.toString(i));
                dfs(temp, idx+1, n);
            }
        }
        else {
            System.out.println(num);
            return;
        }
    }

}